import { Component, OnInit } from '@angular/core';
import { DemoService } from '../demo.service';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    vm = {
        "c": "",
        "r": "",
        "data": ""
    };
    fileText;
    constructor(private ser: DemoService) { }

    ngOnInit() {
    }

    selectFile(event) {
        let reader = new FileReader();
        reader.readAsText(event.srcElement.files[0]);
        let me = this;
        reader.onload = function () {
            let str = reader.result.split('\r\n');//get each line
            let cxr = str[0].split('x');//get column count and row count
            if (cxr.length == 2) {//check format witch (column count)x(rowcount)
                let c = me.vm.c = cxr[0];
                let r = me.vm.r = cxr[1];
                let finalStr = "";
                if (str.length - 1 == r) {
                    for (let i = 1; i < str.length; i++) {
                        if (str[i].split(" ").length != c) {
                            alert("Column count in row " + i + " not same at format on first!");
                            return;
                        }
                        if (i == str.length - 1) {
                            finalStr += str[i];
                        } else {
                            finalStr += str[i]+ "\r\n";
                        }
                    }

                    me.vm.data = me.fileText = finalStr;
                    me.ser.read(me.vm).subscribe(response => {
                        let data = response.json();
                        if (data.status = "Success") {

                        }
                    }, error => {
                        alert("Server error!");
                    });
                } else {
                    alert("Row count not same at format on first!");
                }
            } else {
                alert("Wrong format");
            }
        }
    }

    public create() {
        this.ser.create(this.vm).subscribe(res => {
            let data = res.json();
            if (data.status == "Success") {
                this.fileText = data.result;
            }
        }, error => {
            alert("Server error!");
        });
    }

    public save() {
        this.ser.save().subscribe(res => {
            let data = res.json();
            if (data.status == "Success") {
                alert("Save complete!");
            } else {
                alert(data.message);
            }
        }, error => {
            alert("Server error!");
        });
    }

}
