import { AfterViewInit, Component, OnInit } from '@angular/core';
import { TrademarkService } from 'src/app/services/trademark.service';

declare const Xonomy: any;
declare const MyObj: any;

@Component({
  selector: 'app-trademark-form',
  templateUrl: './trademark-form.component.html',
  styleUrls: ['./trademark-form.component.scss']
})
export class TrademarkFormComponent implements OnInit, AfterViewInit {

  constructor(private trademark_service: TrademarkService) { }

  ngOnInit(): void {
    // console.log("KONSTANTA JE : " + some_const.int_num);
    console.log("KONSTANA IME : " + MyObj.ime);
  }

  ngAfterViewInit() {
    let trademark_form = document.getElementById("trademark-form");
    let spec = this.trademark_service.trademark_specification;
    Xonomy.render('<trademark> </trademark>', trademark_form, spec);

  }

  send() {
    let text = Xonomy.harvest();

    // const entity = text;
    console.log(text);

    this.trademark_service.sendXml(text).subscribe(
      response=>{
        console.log(response);
      }
    );
  }

}
