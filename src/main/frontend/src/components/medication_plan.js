import axios from "axios";
import React from "react";

import {Link} from "react-router-dom";

import {translate} from "react-i18next";

// See https://facebook.github.io/react/docs/forms.html for documentation about forms.
class MedicationPlan extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
        		drugs : []
        };

    }


	// for html conversion
	createMarkup(text) { return {__html: text}; };
	    
    render() {
        const {t} = this.props;
        var tempDate = new Date();
        var date = tempDate.getDate() + '.' + (tempDate.getMonth()+1) + '.' + tempDate.getFullYear();
        var time = tempDate.getHours() + ':' + tempDate.getMinutes();
        axios.get('/drug/list/taking')
            .then(({data}) => {
                this.state.drugs = data.value;
            });
        return (
        	<div>
                {this.state.drugs.length < 1 ? (
                    <div>
                        <div className="container marketing no-banner">
                            <div className='page-header'>
                                <div className='btn-toolbar pull-right'>
                                    <div className='btn-group'></div>
                                </div>
                                <h3>{t('medicationPlan')}</h3>
                            </div>
                            <div className="col-md-12" dangerouslySetInnerHTML={this.createMarkup(t('medicationEmpty'))} />
                            <Link to="/drug/list"><button type="button" className="btn btn-default">{t('addDrugsToMedicationPlan')}</button></Link>
                        </div>

                    </div>
                    ):(
                    <div>
                        <div className="container marketing no-banner">
                            <div className='page-header'>
                                <div className='btn-toolbar pull-right'>
                                    <div className='btn-group'></div>
                                </div>
                                <h3 class="text-center">{t('medicationPlan')}</h3>
                                <h5>{t('for') + ' ' + date} </h5>
                            </div>
                            <div className="col-md-12" dangerouslySetInnerHTML={this.createMarkup(t('medicationPlan'))} />
                        </div>
                    </div>
                )
                }
            </div>
        		


        );
    }
}

export default translate()(MedicationPlan);
