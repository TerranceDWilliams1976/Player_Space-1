import { Component, OnInit } from "@angular/core";

@Component({
  selector: "anms-have",
  templateUrl: "./have.component.html",
  styleUrls: ["./have.component.scss"]
})
export class HaveComponent implements OnInit {
  apiHave;
  //Get-------------------------------------------------
  getHave() {
    const url = "http://localhost:8080/have";
    fetch(url)
      .then(resp => resp.json())
      .then(resp => (this.apiHave = resp));
  }

  //Delete-------------------------------------------------
  deleteHave(game_id) {
    const url = "http://localhost:8080/have/" + game_id;
    const options = {
      method: "Delete"
    };

    fetch(url, options)
      // .then(resp => resp.json())
      // .then(resp => {this.getWant();(console.log(resp))});
      .then(resp => {
        this.getHave();
        console.log(resp);
      });
  }

  constructor() {}

  ngOnInit() {}
}
