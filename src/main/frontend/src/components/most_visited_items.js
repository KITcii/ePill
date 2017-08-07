import axios from "axios";
import React from "react";

import {translate} from "react-i18next";

import DrugMiniature from "./drug_miniature";

import User from "./../util/User";

class MostVisitedItems extends React.Component {
	  constructor(props) {
	    super(props);
	    this.state = {
	    		invocations	: []
	    }

        this.getMostVisitedItems = this.getMostVisitedItems.bind(this);
	  }


	  componentDidMount() {
		  this.getMostVisitedItems();
	  }
	  
	  getMostVisitedItems() {
  		if(!User.isAuthenticated())
			return;

		axios.get(`/drug/frequentlyVisited`)
        .then(({data, status}) => {
        		this.setState({ invocations : data });
        });
	  }

	  
	  render() {
	      const {t} = this.props;
	      const invocations = this.state.invocations;

	      if(!invocations || invocations.length == 0) {
	    	  	return null;
	      }

	      return (
			      <div className="container">
			      	<div className="row last-visited-items-container">
			      		<div className="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-muted">
			      			{t('mostVisitedItems')}:
			      		</div>
			      		{ invocations.map(invocation => <DrugMiniature invocation={invocation} key={invocation.drug.id} /> ) }
			      	</div>
			      </div>
	      );
	  }
	}

export default translate()(MostVisitedItems);