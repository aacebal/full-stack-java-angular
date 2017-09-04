import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public submitted: boolean;
  roomSearch: FormGroup;
  rooms: Room[];

  ngOnInit() {
    this.roomSearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    })

    this.rooms = ROOMS;
  }

  onSubmit({value, valid}: {value: RoomSearch, valid: boolean}) {
    console.log(value);
  }
}

export interface RoomSearch {
  checkin: string;
  checkout: string;
}

export interface Room {
  id: string;
  roomNumber: string;
  price: string;
  links: string
}

var ROOMS: Room[] = [
  {
    "id": "12345",
    "roomNumber": "409",
    "price": "20",
    "links": ""
  },
  {
    "id": "23456",
    "roomNumber": "410",
    "price": "25",
    "links": ""
  },
  {
    "id": "34567",
    "roomNumber": "411",
    "price": "30",
    "links": ""
  }
]
