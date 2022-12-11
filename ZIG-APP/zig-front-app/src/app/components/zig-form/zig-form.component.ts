import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Zig } from 'src/app/model/Zig';
import { ZigService } from 'src/app/services/zig.service';


declare const Xonomy: any;


@Component({
  selector: 'app-zig-form',
  templateUrl: './zig-form.component.html',
  styleUrls: ['./zig-form.component.css']
})
export class ZigFormComponent implements OnInit, AfterViewInit {

  constructor(private zig_service: ZigService) { }

  ngOnInit(): void {
    // console.log("KONSTANTA JE : " + some_const.int_num);
  }

  ngAfterViewInit() {
    let zig_form = document.getElementById("zig_form");
    let spec = this.zig_service.zig_specification;
    Xonomy.render('<zi:zig xmlns:zi="http://ftn.uns.ac.rs/zig" xmlns:util="http://ftn.uns.ac.rs/util"> </zi:zig>', zig_form, spec);

  }

  send() {
    let text = Xonomy.harvest();

    // const entity = text;
    console.log(text);

    // this.inser.sendXml(entity).subscribe(
    //   response=>{
    //     console.log(response);
    //   }
    // );
  }

}
