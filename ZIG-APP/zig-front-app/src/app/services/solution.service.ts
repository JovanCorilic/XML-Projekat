import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { MyDocument } from '../model/document';

declare const Xonomy: any;

@Injectable({
  providedIn: 'root'
})
export class SolutionService {

  private path = "http://localhost:8888/trademark/getImages/"

  private solution = "http://localhost:8888/trademark/solution/save"

  private headers = new HttpHeaders().set('Content-Type', 'application/xml');


  constructor(private http: HttpClient) { }

  getAllImages(uuid: string):Observable<MyDocument[]>  {
    return this.http.get<MyDocument[]>( this.path + uuid , { headers: this.headers });
  }

  save(text: string):Observable<Boolean>  {
    return this.http.post<Boolean>( this.solution , text , { headers: this.headers });
  }

  error(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }


  public solution_specification = {
    elements: {
      "solution":{
        menu:[
          {

            caption: 'Add <institution>',
            action: Xonomy.newElementChild,
            actionParameter: '<institution> </institution>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("institution");
              }

          },
          {

            caption: 'Add <date>',
            action: Xonomy.newElementChild,
            actionParameter: '<date> </date>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("date");
              }

          },
          {

            caption: 'Add <trademark_number>',
            action: Xonomy.newElementChild,
            actionParameter: '<trademark_number> </trademark_number>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("trademark_number");
              }

          }
        ]
      }
      ,
      "institution": {
        menu: [
        {

          caption: 'Add <trademark_sample>',
          action: Xonomy.newElementChild,
          actionParameter: '<trademark_sample> </trademark_sample>',
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("trademark_sample");
            }

        },
        {

          caption: 'Add <list_of_goods_and_services>',
          action: Xonomy.newElementChild,
          actionParameter: '<list_of_goods_and_services> </list_of_goods_and_services>',
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("list_of_goods_and_services");
            }

        },
        {

          caption: 'Add <power_of_attorney>',
          action: Xonomy.newElementChild,
          actionParameter: '<power_of_attorney> </power_of_attorney>',
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("power_of_attorney");
            }

        },
        {

          caption: 'Add <general_power_of_attorney_previously_submitted>',
          action: Xonomy.newElementChild,
          actionParameter: '<general_power_of_attorney_previously_submitted> </general_power_of_attorney_previously_submitted>',
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("general_power_of_attorney_previously_submitted");
            }

        },
        {

          caption: 'Add <power_of_attorney_will_be_delivered_later>',
          action: Xonomy.newElementChild,
          actionParameter: '<power_of_attorney_will_be_delivered_later> </power_of_attorney_will_be_delivered_later>',
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("power_of_attorney_will_be_delivered_later");
            }

        },
        {

          caption: 'Add <general_act>',
          action: Xonomy.newElementChild,
          actionParameter: '<general_act> </general_act>',
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("general_act");
            }

        },
        {

          caption: 'Add <proof_of_priority>',
          action: Xonomy.newElementChild,
          actionParameter: '<proof_of_priority> </proof_of_priority>',
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("proof_of_priority");
            }

        },
        {

          caption: 'Add <proof_of_fee_payment>',
          action: Xonomy.newElementChild,
          actionParameter: '<proof_of_fee_payment> </proof_of_fee_payment>',
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("proof_of_fee_payment");
            }

        }
      ]
      },


      "trademark_sample":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "list_of_goods_and_services":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },
      "power_of_attorney":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },
      "general_power_of_attorney_previously_submitted":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },
      "power_of_attorney_will_be_delivered_later":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },
      "general_act":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },


      "proof_of_priority":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "proof_of_fee_payment":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      }

    }
  }

}
