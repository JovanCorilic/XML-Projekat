import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Trademark } from '../model/trademark';
import { throwError } from 'rxjs';


declare const Xonomy: any;

@Injectable({
  providedIn: 'root'
})
export class TrademarkService {

  private path = "http://localhost:8888/trademark/save"

  private headers = new HttpHeaders().set('Content-Type', 'application/xml');

  constructor(private http: HttpClient) { }

  sendXml(entity: Trademark) {
    return this.http.post(this.path, entity, { headers: this.headers });
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

  public trademark_specification = {
    elements: {
      "trademark": {
        menu: [{

          caption: 'Add <applicant>',
          action: Xonomy.newElementChild,
          actionParameter: '<applicant> </applicant>',
          mustBeBefore:['proxy','common_representative','trademark_info','nice_classification','requested_right_of_priority_and_basis','fee','institution','trademark_number','date'],
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("applicant");
            }

        },
        {

          caption: 'Add <proxy>',
          action: Xonomy.newElementChild,
          actionParameter: '<proxy> </proxy>',
          mustBeBefore:['common_representative','trademark_info','nice_classification','requested_right_of_priority_and_basis','fee','institution','trademark_number','date'],
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("proxy");
            }
        },
        {

          caption: 'Add <common_representative>',
          action: Xonomy.newElementChild,
          actionParameter: '<common_representative> </common_representative>',
          mustBeBefore:['trademark_info','nice_classification','requested_right_of_priority_and_basis','fee','institution','trademark_number','date'],
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("common_representative");
            }
        },
        {

          caption: 'Add <trademark_info>',
          action: Xonomy.newElementChild,
          actionParameter: '<trademark_info> </trademark_info>',
          mustBeBefore:['nice_classification','requested_right_of_priority_and_basis','fee','institution','trademark_number','date'],
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("trademark_info");
            }
        },
        // {

        //   caption: 'Add <nice_classification>',
        //   action: Xonomy.newElementChild,
        //   actionParameter: '<nice_classification> </nice_classification>',
        //   mustBeBefore:['requested_right_of_priority_and_basis','fee','institution','trademark_number','date'],
        //   hideIf: function(jsElement:any){
        //     return jsElement.hasChildElement("nice_classification");
        //     }
        // },
        {

          caption: 'Add <requested_right_of_priority_and_basis>',
          action: Xonomy.newElementChild,
          actionParameter: '<requested_right_of_priority_and_basis> </requested_right_of_priority_and_basis>',
          mustBeBefore:['fee','institution','trademark_number','date'],
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("requested_right_of_priority_and_basis");
            }
        },
        {

          caption: 'Add <fee>',
          action: Xonomy.newElementChild,
          actionParameter: '<fee> </fee>',
          mustBeBefore:['institution','trademark_number','date'],
          hideIf: function(jsElement:any){
            return jsElement.hasChildElement("fee");
            }
        },
        // {

        //   caption: 'Add <institution>',
        //   action: Xonomy.newElementChild,
        //   actionParameter: '<institution> </institution>',
        //   mustBeBefore:['trademark_number','date'],
        //   hideIf: function(jsElement:any){
        //     return jsElement.hasChildElement("institution");
        //     }
        // },
        // {

        //   caption: 'Add <trademark_number>',
        //   action: Xonomy.newElementChild,
        //   actionParameter: '<trademark_number> </trademark_number>',
        //   mustBeBefore:['date'],
        //   hideIf: function(jsElement:any){
        //     return jsElement.hasChildElement("trademark_number");
        //     }
        // },
        // {

        //   caption: 'Add <date>',
        //   action: Xonomy.newElementChild,
        //   actionParameter: '<date> </date>',
        //   hideIf: function(jsElement:any){
        //     return jsElement.hasChildElement("date");
        //     }
        // },
       ]}
       ,
       "applicant":{
        menu:[

          {

            caption: 'Add <subject>',
            action: Xonomy.newElementChild,
            actionParameter: '<subject> </subject>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("subject") ;
              }
          },
          {

            caption: 'Add <address>',
            action: Xonomy.newElementChild,
            actionParameter: '<address> </address>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("address");
              }
          },

          {

            caption: 'Add <contact>',
            action: Xonomy.newElementChild,
            actionParameter: '<contact> </contact>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("contact");
              }
          }

          ]
        },
        "proxy":{
          menu:[

            {

              caption: 'Add <subject>',
              action: Xonomy.newElementChild,
              actionParameter: '<subject> </subject>',
              hideIf: function(jsElement:any){
                return jsElement.hasChildElement("subject") ;
                }
            },
            {

              caption: 'Add <address>',
              action: Xonomy.newElementChild,
              actionParameter: '<address> </address>',
              hideIf: function(jsElement:any){
                return jsElement.hasChildElement("address");
                }
            },

            {

              caption: 'Add <contact>',
              action: Xonomy.newElementChild,
              actionParameter: '<contact> </contact>',
              hideIf: function(jsElement:any){
                return jsElement.hasChildElement("contact");
                }
            }

            ]
          },
          "common_representative":{
            menu:[

              {

                caption: 'Add <subject>',
                action: Xonomy.newElementChild,
                actionParameter: '<subject> </subject>',
                hideIf: function(jsElement:any){
                  return jsElement.hasChildElement("subject") ;
                  }
              },
              {

                caption: 'Add <address>',
                action: Xonomy.newElementChild,
                actionParameter: '<address> </address>',
                hideIf: function(jsElement:any){
                  return jsElement.hasChildElement("address");
                  }
              },

              {

                caption: 'Add <contact>',
                action: Xonomy.newElementChild,
                actionParameter: '<contact> </contact>',
                hideIf: function(jsElement:any){
                  return jsElement.hasChildElement("contact");
                  }
              }

              ]
            },


       "subject":{
        menu:[

          {

            caption: 'Add <user>',
            action: Xonomy.newElementChild,
            actionParameter: '<user> </user>',
            hideIf: function(jsElement:any){
              return  jsElement.hasChildElement("user") ||jsElement.hasChildElement("company");
              }
          },
          {

            caption: 'Add <company>',
            action: Xonomy.newElementChild,
            actionParameter: '<company> </company>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("user") ||jsElement.hasChildElement("company");
              }
          }

          ]
        },

        "user":{
          menu:[
            {

              caption: 'Add <first_name>',
              action: Xonomy.newElementChild,
              actionParameter: '<first_name> </first_name>',
              hideIf: function(jsElement:any){
                return jsElement.hasChildElement("first_name");
                }
            },
            {

              caption: 'Add <last_name>',
              action: Xonomy.newElementChild,
              actionParameter: '<last_name> </last_name>',
              hideIf: function(jsElement:any){
                return jsElement.hasChildElement("last_name");
                }
            }


            ]
          },

       "address":{
        menu:[
          {

            caption: 'Add <street_name>',
            action: Xonomy.newElementChild,
            actionParameter: '<street_name> </street_name>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("street_name");
              }
          },
          {

            caption: 'Add <street_number>',
            action: Xonomy.newElementChild,
            actionParameter: '<street_number> </street_number>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("street_number");
              }
          },
          {

            caption: 'Add <zip_code>',
            action: Xonomy.newElementChild,
            actionParameter: '<zip_code> </zip_code>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("zip_code");
              }
          },
          {

            caption: 'Add <city>',
            action: Xonomy.newElementChild,
            actionParameter: '<city> </city>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("city");
              }
          },
          {

            caption: 'Add <country>',
            action: Xonomy.newElementChild,
            actionParameter: '<country> </country>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("country");
              }
          }

        ]

       },

       "contact":{
        menu:[
          {

            caption: 'Add <phone>',
            action: Xonomy.newElementChild,
            actionParameter: '<phone> </phone>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("phone");
              }
          },
          {

            caption: 'Add <faks>',
            action: Xonomy.newElementChild,
            actionParameter: '<faks> </faks>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("faks");
              }
          },
          {

            caption: 'Add <mail>',
            action: Xonomy.newElementChild,
            actionParameter: '<mail> </mail>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("mail");
              }
          }

        ]

       },

       "trademark_info":{
        menu: [
          {

            caption: 'Add <trademark_type>',
            action: Xonomy.newElementChild,
            actionParameter: '<trademark_type> </trademark_type>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("trademark_type");
              }
          },
          {

            caption: 'Add <trademark_appearance>',
            action: Xonomy.newElementChild,
            actionParameter: '<trademark_appearance> </trademark_appearance>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("trademark_appearance");
              }
          },
          {

            caption: 'Add <trademark_view>',
            action: Xonomy.newElementChild,
            actionParameter: '<trademark_view> </trademark_view>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("trademark_view");
              }
          },
          {

            caption: 'Add <trademark_colors>',
            action: Xonomy.newElementChild,
            actionParameter: '<trademark_colors> </trademark_colors>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("trademark_colors");
              }
          },
          {

            caption: 'Add <trademark_transliteration>',
            action: Xonomy.newElementChild,
            actionParameter: '<trademark_transliteration> </trademark_transliteration>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("trademark_transliteration");
              }
          },
          {

            caption: 'Add <trademark_translation>',
            action: Xonomy.newElementChild,
            actionParameter: '<trademark_translation> </trademark_translation>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("trademark_translation");
              }
          },
          {

            caption: 'Add <trademark_description>',
            action: Xonomy.newElementChild,
            actionParameter: '<trademark_description> </trademark_description>',
            hideIf: function(jsElement:any){
              return jsElement.hasChildElement("trademark_description");
              }
          }
        ]
      },


       "trademark_colors":{
        menu: [
          {

            caption: 'Add <trademark_color>',
            action: Xonomy.newElementChild,
            actionParameter: '<trademark_color> </trademark_color>',

          }
        ]
      },

       "fee":{
        menu: [

            {

              caption: 'Add <basic>',
              action: Xonomy.newElementChild,
              actionParameter: '<basic> </basic>',
              hideIf: function(jsElement:any){
                return jsElement.hasChildElement("basic");
                }
            },
            {

              caption: 'Add <nice_class>',
              action: Xonomy.newElementChild,
              actionParameter: '<nice_class> </nice_class>',
              hideIf: function(jsElement:any){
                return jsElement.hasChildElement("nice_class");
                }
            },
            {

              caption: 'Add <graphical_solution>',
              action: Xonomy.newElementChild,
              actionParameter: '<graphical_solution> </graphical_solution>',
              hideIf: function(jsElement:any){
                return jsElement.hasChildElement("graphical_solution");
                }
            }



        ],

        },

       "institution":{
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

        ],

      },

       "first_name":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "last_name":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

       "company":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "street_name":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "street_number":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "zip_code":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "city":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "country":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "phone":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "faks":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },



      "mail":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },


      "trademark_type": {
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askPicklist,
        askerParameter: [
          { value: "IndividualTrademark" },
          { value: "CollectiveTrademark" },
          { value: "GuaranteeTrademark" }
        ]
      },

      "trademark_appearance": {
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askPicklist,
        askerParameter: [
          { value: "VerbalTrademark" },
          { value: "GraphicTrademark" },
          { value: "CombinedTrademark" },
          { value: "ThreeDimensionalTrademark" },
          { value: "AnotherTrademark" }
        ]
      },

      "trademark_view":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "trademark_color":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "trademark_transliteration":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "trademark_translation":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "trademark_description":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "nice_classification":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askPicklist,
        askerParameter: [
          { value: "1" },
          { value: "2" },
          { value: "3" },
          { value: "4" },
          { value: "5" },
          { value: "6" },
          { value: "7" },
          { value: "8" },
          { value: "9" },
          { value: "10" },
          { value: "11" },
          { value: "12" },
          { value: "13" },
          { value: "14" },
          { value: "15" },
          { value: "16" },
          { value: "17" },
          { value: "18" },
          { value: "19" },
          { value: "20" },
          { value: "21" },
          { value: "22" },
          { value: "23" },
          { value: "24" },
          { value: "25" },
          { value: "26" },
          { value: "27" },
          { value: "28" },
          { value: "29" },
          { value: "30" },
          { value: "31" },
          { value: "32" },
          { value: "33" },
          { value: "34" },
          { value: "35" },
          { value: "36" },
          { value: "37" },
          { value: "38" },
          { value: "39" },
          { value: "40" },
          { value: "41" },
          { value: "42" },
          { value: "43" },
          { value: "44" },
          { value: "45" }
        ]
      },

      "requested_right_of_priority_and_basis":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "basic":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "nice_class":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "graphical_solution":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
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
      },

      "trademark_number":{
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,
      },

      "date": {
        hasText: true,
        oneltmer: true,
        asker: Xonomy.askString,


      },


     }


  }

}
