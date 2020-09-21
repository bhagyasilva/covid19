import {Component, OnInit} from '@angular/core';
import {DashboardService} from '../../services/dashboard.service';
import * as Highcharts from 'highcharts/highmaps';
import mapdata from '../../mapdata';
// import * as Uganda from '@highcharts/map-collection/countries/ug/ug-all.geo.json';
// import HC_map from 'highcharts/modules/map';
//
// HC_map(Highcharts);
import {Options} from 'highcharts';
// @ts-ignore
// import worldMap from '@highcharts/map-collection/custom/world.geo.json';
// import srilanka from '@highcharts/map-collection/countries/lk/lk-all.geo.json';
import srilanka from '../../../assets/highcharts/lk/lk-all.geo.json';
import {interval} from 'rxjs';


mapdata(Highcharts);

export interface PeriodicElement {
  application_no: number;
  td_no: string;
  id_no: string;
  dob: string;
  td_type: string;
  previous_id_no: string;
  view: string;
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})


export class DashboardComponent implements OnInit {
  Highcharts: typeof Highcharts = Highcharts;
  updateFromInput = false;
  chartConstructor = 'mapChart';
  chartData = [{code3: 'ABW', z: 105}, {code3: 'AFG', z: 35530}];
  data = [
    ['lk-bc', 0],
    ['lk-mb', 0],
    ['lk-ja', 0],
    ['lk-kl', 0],
    ['lk-ky', 0],
    ['lk-mt', 0],
    ['lk-nw', 0],
    ['lk-ap', 0],
    ['lk-pr', 0],
    ['lk-tc', 0],
    ['lk-ad', 0],
    ['lk-va', 0],
    ['lk-mp', 0],
    ['lk-kg', 0],
    ['lk-px', 0],
    ['lk-rn', 0],
    ['lk-gl', 0],
    ['lk-hb', 0],
    ['lk-mh', 0],
    ['lk-bd', 0],
    ['lk-mj', 0],
    ['lk-ke', 0],
    ['lk-co', 0],
    ['lk-gq', 0],
    ['lk-kt', 0]
  ];

  chartOptions: Options = {
    chart: {
      map: srilanka as any
    },
    title: {
      text: 'Sri Lanka COVID19 Patient Count by District'
    },
    mapNavigation: {
      enabled: true,
      buttonOptions: {
        alignTo: 'spacingBox'
      }
    },
    legend: {
      enabled: true
    },
    colorAxis: {
      min: 0
    },
    series: [
      {
        type: 'map',
        name: 'Patient Count',
        states: {
          hover: {
            color: '#da5593'
          }
        },
        dataLabels: {
          enabled: true,
          format: '{point.name}'
        },
        allAreas: false,
        data: this.data as any
      }
    ],
    exporting: {
      enabled: true
    },
  };

  constructor(private dashboardService: DashboardService) {
  }

  ngOnInit(): void {
    // localStorage.clear();
    this.loadPreviousData();
    this.getAllDistrictCount();

  }

  private loadPreviousData(): void {
    this.data.forEach((temp: any) => {
      let keyVal = '';
      if (temp[0]) {
        keyVal = ('bhagya_covid19_' + temp[0]).toLowerCase().toString().trim();
      } else if (temp['hc-key']) {
        keyVal = ('bhagya_covid19_' + temp['hc-key']).toLowerCase().toString().trim();
      }
      const key = (keyVal).toLowerCase().toString().trim();
      const itemValue = localStorage.getItem(key);
      const itemNumber: number = itemValue ? +itemValue : 0;
      if (temp[0]) {
        temp[1] = itemNumber;
      } else if (temp['hc-key']) {
        temp['hc-key'] = itemNumber;
      }
    });
// this.updateData(this.data);
  }

  private getAllDistrictCount(): void {
    interval(20000).subscribe(() => {
      this.dashboardService.getAllDistrictCount().subscribe(res => {
        if (res && res.length > 0) {
          res.forEach((r: any) => {
            this.data.forEach((temp: any) => {
              if (temp['hc-key'] === r.districtCode) {
                const key = ('bhagya_covid19_' + temp['hc-key']).toLowerCase().toString().trim();
                const value = (r.totalCount).toString().trim();
                localStorage.setItem(key, value);
                temp.value = r.totalCount;
              }
            });
          });
          this.updateData(this.data);
        }
      }, () => {
      });
    });


  }

  updateData(data): void {
    // this.updateFromInput = false;
    // @ts-ignore
    this.chartOptions.series[0].data = data;
    this.updateFromInput = true;
  }


}
