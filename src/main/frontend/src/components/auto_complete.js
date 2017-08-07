import axios from "axios";
import React from "react";

import {Link} from "react-router-dom";
import {withRouter} from 'react-router';
import {translate} from "react-i18next";

class UserMenue extends React.Component {
	  constructor(props) {
	    super(props);
	    	    
	    this.state = {
	    		drugs	: [],
	    		exp		: '',
	    		selectedValue	: '',
	    		show		: false,
	    		loading	: false
	    }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleExpressionChange = this.handleExpressionChange.bind(this);
        this.handleSelectedValueChange = this.handleSelectedValueChange.bind(this);
        
        this.hide = this.hide.bind(this);
        this.show = this.show.bind(this);
        
	  }

	  handleSubmit(event) {
	      event.preventDefault();
	      
	  }
	  
	  handleExpressionChange(event) {
		  this.state.exp = event.target.value
		  this.state.loading = true;
		  this.state.show= true;
		  	
	      this.setState(this.state);
		  	
	      axios.get('/drug/search', { params : { exp : this.state.exp } })
	      	.then(({data}) => {
	      		this.state.drugs = data.value
	      		this.state.loading = false;
	      		this.setState(this.state);
	        });
	  }
	  
	  handleSelectedValueChange(drug, event) {
		  this.state.selectedValue = drug.name;
		  this.state.exp = this.state.selectedValue;
		  this.setState(this.state);
	  }
	  
	  
	  show(event) {
		  this.state.show = true;
		  this.setState(this.state);
	  }
	  
	  hide(event) {
		  this.state.show = false;
		  this.setState(this.state);
	  }
	  
	  renderResults(drugs) {
		  if(!drugs)
			  return null;
		
		  return drugs.map(drug => <li key={"aC"+drug.id} onMouseOver={() => this.handleSelectedValueChange(drug) } onClick={ this.hide }><Link to={`/drug/${drug.id}`} className="wide">{drug.name}</Link></li> );
	  }

	  
	  render() {
	    const {t} = this.props;
	    
	    const drugs	= this.state.drugs;
	    const show	= this.state.show;
	    const exp	= this.state.exp;
	    const loading = this.state.loading;

	    return (
	    		<div>
		    		<form className="navbar-form navbar-left" onSubmit={this.handleSubmit} >
		    			<div className="col-sm-12 col-md-12 col-lg-12">
		    				<div className="row">
		    					<input type="text" value={this.state.exp} onChange={this.handleExpressionChange} name="search" className="form-control"
		    						placeholder={ t("searchDrug") } autoComplete="off" autoCorrect="off" autoCapitalize="off" />
		    					<button className="btn btn-outline-success btn-search" type="submit">
		    						<span className="glyphicon glyphicon-search"></span>
		    					</button>
		    				</div>
		    				{show && exp.length > 0 && !loading &&
		    					<div className="row">
			    					<ul className="ui-autocomplete">
	    								{this.renderResults(drugs)}
			    						{drugs.length == 0 && <li className="no-results">leider keine passenden Ergebnisse gefunden</li> }
			    					</ul>
			    				</div>
		    				}
		    			</div>
		    		</form>
		    	</div>
	    );
	  }
	}

export default translate()(UserMenue);