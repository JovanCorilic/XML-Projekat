import { ResenjeService } from './../../SERVICE/resenje.service';
import { XonomyResenjeCreateService } from './../../SERVICE/xonomyResenjeCreateService.service';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatentService } from 'src/app/SERVICE/patent.service';

declare const Xonomy:any;

@Component({
  selector: 'app-edit-resenje',
  templateUrl: './edit-resenje.component.html',
  styleUrls: ['./edit-resenje.component.css']
})
export class EditResenjeComponent {
  patentId=<string>{}
  temp:string|null;

  constructor(
    private resenjeService:ResenjeService,
    private router:Router,
    private route:ActivatedRoute,
    private xonomyResenjeEdit:XonomyResenjeCreateService
  ) {
    this.temp=this.route.snapshot.paramMap.get('resenje');
      if(this.temp != null)
        this.patentId = this.temp;
      else
        this.patentId = "nista";
   }

  ngOnInit(): void {
  
  this.resenjeService.getResenje(this.patentId).subscribe(
    res=>{
      let element = document.getElementById("editor");
      let specification = this.xonomyResenjeEdit.resenjeSpecification;
      let xmlString = res;
      Xonomy.setMode("laic");
      Xonomy.render(xmlString, element, specification);
      
      Xonomy.refresh();
    }
  )
}

send(){
  let text = Xonomy.harvest();
  
  text = '<?xml version="1.0" encoding="UTF-8"?>'+ text;
  
  this.resenjeService.editResenje(text).subscribe(
    res=>{
      this.router.navigate(['/svaResenja']);
    }
  )
}

natrag(){
  this.router.navigate(['/svaResenja']);
}

}
