import { Component, OnInit } from "@angular/core";

@Component({
  selector: "anms-want",
  templateUrl: "./want.component.html",
  styleUrls: ["./want.component.scss"]
})
export class WantComponent implements OnInit {
  apiWant;

  //Get-------------------------------------------------
  getWant() {
    const url = "http://localhost:8080/want";
    fetch(url)
      .then(resp => resp.json())
      .then(resp => (this.apiWant = resp));
  }

  //Delete-------------------------------------------------
  deleteWant(game_id) {
    const url = "http://localhost:8080/want/" + game_id;
    const options = {
      method: "Delete"
    };

    fetch(url, options)
      // .then(resp => resp.json())
      // .then(resp => {this.getWant();(console.log(resp))});
      .then(resp => {
        this.getWant();
        console.log(resp);
      });
  }

  constructor() {}

  ngOnInit() {}
}
