import axios from "axios";
import React from "react";

import {Link} from "react-router-dom";

import {translate} from "react-i18next";
import Loading from "./loading";
import User from "./../util/User";
import moment from 'moment';

// See https://facebook.github.io/react/docs/forms.html for documentation about forms.
class MedicationPlan extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            drugsplanned: [],
            date : new Date(),
            halftimeperiod: 0
        };
        
    }

    // This function is called before render() to initialize its state.
    componentWillMount() {
        console.log("componentWillMount");
        this.getData();
    }

    getData() {
        this.state.loading = true;
        this.setState(this.state);
        console.log("getting userdrugplanned");
        axios.get("/drug/list/userdrugplanned/date", {
               		params: {
                          date: this.state.date
                        }
                      }).then(({ data }) => {
         this.state.drugsplanned = data.value;
         this.state.loading = false;
         this.setState(this.state);
        });
    }

    // for html conversion
    createMarkup(text) {
        return { __html: text };
    }
    
    update(){
    	this.forceUpdate();
    }
    
    changeDate (incrementBy) {
        console.log("setDate");
        this.state.date.setTime(this.state.date.getTime() + incrementBy * 86400000);
        this.setState(this.state);
        this.getData();
    }
    
    formatDate(datetime) {
        var formatted_date = moment(datetime).format("DD.MM.YYYY hh::mm");
        return formatted_date;
    }
    
    getHalfTimePeriod(drug){
    	this.state.loading = true;
        this.setState(this.state);
        console.log("getting halftimeperiod");
        axios.get("/drug", {
               		params: {
                          drug: drug
                        }
                      }).then(({ data }) => {
         this.state.halftimeperiod = data.value;
         this.state.loading = false;
         this.setState(this.state);
        });
        return this.state.halftimeperiod;
    }
    
    renderDrugsPlanned(drugsplanned) {
        return drugsplanned.map(drugplanned => {
            return (
                <tr key={drugplanned.id}>
                	<td>{drugplanned.drug.name}</td>
                	<td>{this.formatDate(drugplanned.datetime_intake_planned)}</td>
                    <td>{drugplanned.id}</td>
                    <td>{drugplanned.drug.name}</td>
                    <td>{this.getHalfTimePeriod(drugplanned.drug)} + " hours"</td>
                </tr>
            );
        });
    }

    
    
    render() {
        const { t } = this.props;
        const drugsplanned = this.state.drugsplanned;
        const halfTimePeriod = this.state.halfTimePeriod;
        var formatted_date = moment(this.state.date).format("DD.MM.YYYY");
        return (
            <div className="container no-banner">
                <div className="page-header">
                        <div className="text-date-change">
                            <button type="button" className="btn btn-sm btn-date-change" onClick={this.changeDate.bind(this, -1)}>
                            <span className="glyphicon glyphicon-triangle-left"></span>
                            </button>
                            <div className="mp-title">
                                <h3>{t("medicationPlan")}</h3>
                                <p>{" " + (t("for")) + " " + formatted_date}</p>
                            </div>
                            <button type="button" className="btn btn-sm btn-date-change" onClick={this.changeDate.bind(this, 1)}>
                            <span className="glyphicon glyphicon-triangle-right"></span>
                            </button>
                            <button type="button" className="btn btn-sm btn-add btn-add-drug">{t("addDrugsToMedicationPlan")}</button>
                        </div>
                </div>
                <div>
                    {drugsplanned.length > 1 && User.isAuthenticated() && (
                        <div>
                            <p>you have {drugsplanned.length} planned drugs</p>
                            <button type="button" className="btn btn-like btn-sm" onClick={() => this.update()}>
                                <span className="glyphicon glyphicon-white glyphicon-refresh"></span>
                            </button>
                        </div>
                    )}

                    <div>
                        {this.state.loading && <Loading />}
                        {!this.state.loading && drugsplanned && drugsplanned.length == 0 && (
                            <EmptyList />
                        )}
                        {!this.state.loading && drugsplanned && drugsplanned.length > 0 && (
                            <table id="drugsplanned">
                                <tbody>{this.renderDrugsPlanned(drugsplanned)}</tbody>
                            </table>
                        )}
                    </div>
                </div>
                
            </div>
        );
    }
}

export default translate()(MedicationPlan);

