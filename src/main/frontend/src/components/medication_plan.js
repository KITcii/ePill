import axios from "axios";
import React from "react";

import {Link} from "react-router-dom";

import {translate} from "react-i18next";
import Loading from "./loading";
import User from "./../util/User";

// See https://facebook.github.io/react/docs/forms.html for documentation about forms.
class MedicationPlan extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            drugsplanned: [],
            date : new Date()
        };
        this.changeDate = this.changeDate.bind(this)
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
        axios.get("/drug/list/userdrugplanned").then(({ data }) => {
            this.state.drugsplanned = data.value;
            //  '{"value":[{"id":1,"datetime_intake_planned":1566370800000,"drug":{"id":1,"name":"Accupro® 10 Filmtabletten","packaging":[{},{}],"packagingSection":[{},{},{},{},{},{},{}],"activeSubstance":[{}],"pharmaceuticalForm":[{}],"productGroup":{},"indicationGroup":{},"disease":[{},{}],"drugFeature":[{},{},{},{}],"drug_image":{},"year":"2011-01-01","status":"3915-06-01","version":"1.59"},"user":{"id":1,"firstname":"Niclas","lastname":"Kannengiesser","username":"nic","email":"n.kannengiesser@web.de","dateOfBirth":"1990-09-21","dateOfRegistration":1435403761000,"levelOfDetail":3,"country":{},"language":{},"gender":{},"redGreenColorblind":true}},{"id":2,"datetime_intake_planned":1566385200000,"drug":{"id":2,"name":"Baymycard","packaging":[{},{}],"packagingSection":[{},{},{},{},{},{},{},{}],"activeSubstance":[{}],"pharmaceuticalForm":[{}],"productGroup":{},"indicationGroup":{},"disease":[{}],"drugFeature":[{},{},{},{},{},{}],"drug_image":{},"year":"2011-01-01","status":"3915-06-01","version":"1.59"},"user":{"id":1,"firstname":"Niclas","lastname":"Kannengiesser","username":"nic","email":"n.kannengiesser@web.de","dateOfBirth":"1990-09-21","dateOfRegistration":1435403761000,"levelOfDetail":3,"country":{},"language":{},"gender":{},"redGreenColorblind":true}}]}';
            this.state.loading = false;
            this.setState(this.state);
            //console.log("data.value=" + data.value);
        });
    }

    // for html conversion
    createMarkup(text) {
        return { __html: text };
    }
    
    update(){
    	this.forceUpdate();
    }
    
    
    renderDrugsPlanned(drugsplanned) {
        return drugsplanned.map(drugplanned => {
            return (
                <tr key={drugplanned.id}>
                    <td>{drugplanned.datetimeIntakePlanned}</td>
                    <td>{drugplanned.id}</td>
                    <td>{drugplanned.drug.name}</td>
                </tr>
            );
        });
    }

    changeDate = () => {
    	var prevDate = this.state.date;
    	this.setState({date : prevDate.setDate(prevDate.getDate() - 1)})
    }
    
    render() {
        const { t } = this.props;
        const drugsplanned = this.state.drugsplanned;
        var dateForm = this.state.date.getDate() + "." + (this.state.date.getMonth() + 1) + "." + this.state.date.getFullYear();
        return (
            <div className="container no-banner">
                <div className="page-header">
                        <button type="button" className="btn btn-sm btn-date-change" onClick={this.changeDate}>
                        <span className="glyphicon glyphicon-triangle-left"></span>
                        </button>
                        {t("medicationPlan")}
                        <p>{" " + (t("for")) + " " + dateForm}</p>
                        <button type="button" className="btn btn-sm btn-date-change">
                        <span className="glyphicon glyphicon-triangle-right"></span>
                        </button>
                    <button type="button" className="btn btn-sm btn-add btn-add-drug">{t("addDrugsToMedicationPlan")}</button>
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

