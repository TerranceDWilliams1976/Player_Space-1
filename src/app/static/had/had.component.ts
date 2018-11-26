import { Component, OnInit } from "@angular/core";

@Component({
  selector: "anms-had",
  templateUrl: "./had.component.html",
  styleUrls: ["./had.component.scss"]
})
export class HadComponent implements OnInit {
  apiHad;

  //Get-------------------------------------------------
  getHad() {
    const url = "http://localhost:8080/had";
    fetch(url)
      .then(resp => resp.json())
      .then(resp => (this.apiHad = resp));
  }

  //Delete-------------------------------------------------
  deleteHad(game_id) {
    const url = "http://localhost:8080/had/" + game_id;
    const options = {
      method: "Delete"
    };

    fetch(url, options)
      // .then(resp => resp.json())
      // .then(resp => {this.getWant();(console.log(resp))});
      .then(resp => {
        this.getHad();
        console.log(resp);
      });
  }

  constructor() {}

  ngOnInit() {}
}
