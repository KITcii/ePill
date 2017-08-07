import axios from "axios";
import React from "react";

import {translate} from "react-i18next";
import { toast } from 'react-toastify';

import Accordion from "./accordion";
import Loading from "./loading";
import User from "./../util/User";

class DrugDetail extends React.Component {
    constructor(props) {
        super();
        this.state = {
            drug: undefined,
            showAdditionalInfo	: false
        }
        
        this.toggleShowAdditionalInfo = this.toggleShowAdditionalInfo.bind(this);
        this.toggleOriginalAndTailoredText = this.toggleOriginalAndTailoredText.bind(this);
    }

    init() {
        axios.get(`/drug/${this.props.match.params.id}/de`)
        .then(({data, status}) => {
            this.setState({
                drug: data
            });
        });
    }
    
    componentWillMount() {
		this.init();
    }
    
    componentWillReceiveProps(props){
    		this.props = props;
        this.init();
     }
    
    createMarkup(text) { return {__html: text}; };
    
    //=============================
    
    toggleShowAdditionalInfo() {
    		this.setState({ showAdditionalInfo : !this.state.showAdditionalInfo});
    }
    
    
    
    toggleOriginalAndTailoredText(section) {

    		var url = (section.isTailored) ? `packagingSection/tailored/${section.topic.id}/${this.props.match.params.id}` : `packagingSection/${section.topic.id}/${this.props.match.params.id}`;

    		axios.get(url).then(({data, status}) => {

        	 	switch(status) {
        	 		case 200:
        	 			var idx = -1;
        	 			for(var i=0; i<this.state.drug.packagingSection.length; i++) {
        	 				if(this.state.drug.packagingSection[i]["id"] == section["id"]) {
        	 					idx = i;
        	 					break;
        	 				}
        	 			}
        	 			
                		this.state.drug.packagingSection[idx] = data;
                		this.setState(this.state);
                		
        	 			break;
        	 		default:
        	 			const {t} = this.props;
        	 			const options = {
        	 				position: toast.POSITION.BOTTOM_CENTER
        	 			};
        	 			toast.error(t('errorOccured'), options);
        	 			break;
        	 	}
         });

    }
    
    
    //=============================
    
    toggleTaking(drug) {
		if(drug.isTaken) {
			this.removeFromTakingList(drug.id);
		} else {
			this.addToTakingList(drug.id);
		}
    }
    
    addToTakingList(id) {
    	
    	 	axios.post('/drug/taking/add', { id : id }, {
	            validateStatus: (status) => {
	                return (status >= 200 && status < 300) || status == 400 || status == 401
	            }
     		})
         .then(({data, status}) => {
             const {t} = this.props;
             const options = {
             	    position: toast.POSITION.BOTTOM_CENTER
             };

             switch (status) {
                 case 200:
                     toast.success(t('addToTakingListSuccess'), options);
                     this.state.drug.isTaken = true;
                     this.setState(this.state.drug);
                     break;
                 case 400:
                  	toast.error(t('addToTakingListFailed'), options);
                     break;
                 case 401:
                 	console.log(data, "not permitted");
                    	break;
             }
         });
    }
    
    removeFromTakingList(id) {
	 	axios.post('/drug/taking/remove', { id : id }, {
            validateStatus: (status) => {
                return (status >= 200 && status < 300) || status == 400 || status == 401
            }
 		})
	     .then(({data, status}) => {
             const {t} = this.props;
             const options = {
             	    position: toast.POSITION.BOTTOM_CENTER
             };
             
	         switch (status) {
	             case 200:
                     toast.success(t('removeFromTakingListSuccess'), options);
                     this.state.drug.isTaken = !this.state.drug.isTaken;
                     this.setState(this.state.drug);
	                 break;
	             case 400:
                     toast.error(t('removeFromTakingListFailed'), options);
	                 break;
	             case 401:
	             	console.log(data, "not permitted");
	                	break;
	         }
	     });
	}
    
    
    
    /**
     * toggle add/remove to/from remember/taking list
     */
    
    toggleRemember(drug) {
		if(drug.isRemembered) {
			this.removeFromRememberList(drug.id);
		} else {
			this.addToRememberList(drug.id);
		}
    }
    
    addToRememberList(id) {
	 	axios.post('/drug/remember/add', { id : id }, {
            validateStatus: (status) => {
                return (status >= 200 && status < 300) || status == 400 || status == 401 || status == 405
            }
 		})
	     .then(({data, status}) => {
             const {t} = this.props;
             const options = {
             	    position: toast.POSITION.BOTTOM_CENTER
             };
             
	         switch (status) {
	             case 200:
	                 toast.success(t('addToRememberListSuccess'), options);
                     this.state.drug.isRemembered = true;
                     this.setState(this.state.drug);
	                 break;
	             case 400:
	            	 	toast.error(t('addToRememberListFailed'), options);
	            	 	break;
	             case 401:
	             	console.log(data, "not permitted");
	                	break;
	             case 405:
		            console.log(data, "Method not allowed");
		            break;
	         }
	     });
    }
    
    removeFromRememberList(id) {
	 	axios.post('/drug/remember/remove', { id : id }, {
            validateStatus: (status) => {
                return (status >= 200 && status < 300) || status == 400 || status == 401 || status == 405
            }
 		})
	     .then(({data, status}) => {
             const {t} = this.props;
             const options = {
             	    position: toast.POSITION.BOTTOM_CENTER
             };
             
	         switch (status) {
	             case 200:
	                 toast.success(t('removeFromRememberListSuccess'), options);
                     this.state.drug.isRemembered = !this.state.drug.isRemembered;
                     this.setState(this.state.drug);
	                 break;
	             case 400:
	            	 	toast.error(t('removeFromRememberListFailed'), options);
	            	 	break;
	             case 401:
	             	console.log(data, "not permitted");
	                	break;
	             case 405:
		            console.log(data, "Method not allowed");
		            break;
	         }
	     });
    }
    
    
    //=============================
    
    
    renderDrugFeatures(drug) {
		
		if(!drug.drugFeature)
			return;
		
		return (
        		<p>
        			{ drug.drugFeature.map(feature => <img key={feature.id} src={"./../../assets/icons/"+feature.id + ".svg"} alt={feature.drugFeature} title={feature.drugFeature} className="drug-feature-icon"></img> ) }
        		</p>
		);
    }
    
	renderDisease(drug) {
		if(!drug.disease) {
			return;
		}

        const {t} = this.props;
        return (
        		<section className="diseases">
	    			{t('usedWhen')+": "}
	    			{ drug.disease.map(disease => <span key={disease.id}>{disease.name}</span> )
	    				.reduce((prev, curr) => [prev, ', ', curr]) }
	        </section>
		);
	}
	
	renderPharmaceuticalForm(drug) {
		if(!drug.pharmaceuticalForm) {
			return;
		}

        const {t} = this.props;
        return (
        		<section className="diseases">
	    			{t('pharmaceuticalForm')+": "}
	    			{ drug.pharmaceuticalForm.map(pharmaceuticalForm => <span key={pharmaceuticalForm.id}>{pharmaceuticalForm.name}</span> )
	    				.reduce((prev, curr) => [prev, ', ', curr]) }
	        </section>
		);	
	}
	
	renderActiveSubstance(drug) {
		if(!drug.activeSubstance)
			return null;

        const {t} = this.props;
        
        return (
	        <p> {t('activeSubstance')+": "}
			{ drug.activeSubstance.map(substance => <span key={substance.id}>{substance.name}</span> )
				.reduce((prev, curr) => [prev, ', ', curr]) }
			</p>
		);
	}
	
	renderPZN(drug) {
		if(!drug.packaging)
			return null;
			
        const {t} = this.props;
        
        return (
        		<section className="pzn">
	    			{t('pzn')+": "}
	    			{ drug.packaging.map(packaging => <span key={packaging.id}>{packaging.name} {packaging.pzn}</span> )
	    				.reduce((prev, curr) => [prev, ', ', curr]) }
	    		</section>
		);
	}
	

	renderIndicationGroup(drug) {
		if(!drug.indicationGroup || !drug.indicationGroup.name)
			return null;
			
        const {t} = this.props;
        
        return (
        		<section>
	    			{t('indicationGroup')+": "+drug.indicationGroup.name}
	    		</section>
		);
	}
	
	renderProductGroup(drug) {
		
		if(!drug.productGroup || !drug.productGroup.name)
			return null;
			
        const {t} = this.props;
        
        return (
        		<section>
	    			{t('productGroup')+": "+drug.productGroup.name}
	    		</section>
		);
	}
    
    renderSectionOverview(drug) {
    		if(!drug.packagingSection) {
			return null;
		}

        return drug.packagingSection.map((section => {
            return (
            		<li key={section.id}>{section.topic.title}</li>
            );
        }));
    }

    renderSectionList(drug) {
    		if(!drug.packagingSection) {
			return null;
		}
   
    		return drug.packagingSection.map((section => {
            return (	<Accordion section={section} toggleOriginalAndTailoredText={this.toggleOriginalAndTailoredText} key={section.id} /> );
        }));
    }
    
    
    
    
    
    render() {
        const {t}	= this.props;
        const drug	= this.state.drug;
        const showAdditionalInfo = this.state.showAdditionalInfo;
        
        if (!drug) {
            // Do not show anything while loading.
            return (
                	<div className="container marketing no-banner">
	            		<div className='page-header'>
	            			<h3> </h3>
	            		</div>
	            		<Loading />
            		</div>
            );
        }

        return (
	        	<div className="container marketing no-banner">
	        		<div className='page-header'>
	        			<div className='btn-toolbar pull-right'>
	        				<div className='btn-group'></div>
	        			</div>
	        			{User.isAuthenticated()
	        				&&
		        			<div className='btn-toolbar pull-right'>
			        		    <div className='btn-group'>
				    				<button type="button" className="btn btn-like" onClick={() => this.toggleTaking(drug)}>
									<span className={"glyphicon white" + ((!drug.isTaken) ? " glyphicon-heart" : " glyphicon-minus")}></span>
								</button>
								
			        				<button type="button" className="btn btn-add" onClick={() => this.toggleRemember(drug)}>
			        					<span className={"glyphicon white" + ((!drug.isRemembered) ? " glyphicon-plus" : " glyphicon-minus")}></span>
			        				</button>
			        		    </div>
			        		  </div>	
		        			}
	        			
	        			<h3>{drug.name} {drug.productGroup && drug.productGroup.name && <span className="text-muted">{drug.productGroup.name}</span> }</h3>
	        			<span>v. {drug.version} | {t('publishingDate')}: {new Date(drug.year).toLocaleDateString()}</span>
	  
	        		</div>
	        		<div className="row featurette drug-detail-header">
	        			<div className="col-xs-12 col-sm-12 col-md-3">
	        				<img className="featurette-image img-responsive center-block" alt={drug.name} title={drug.name} src={`/image/drug/${drug.id}`}></img>
	                		<div className="drug-features margin-s">
		    					{this.renderDrugFeatures(drug)}
		            		</div>
	        			</div>
	        			<div className="col-xs-12 col-sm-12 col-md-9">
	        				{ User.isAuthenticated() && drug.personalizedInformation &&
	        					<div className="alert alert-info alert-dismissable">
	        						<a href="#" className="close" data-dismiss="alert" aria-label="close">&times;</a>
	        						<span dangerouslySetInnerHTML={this.createMarkup(drug.personalizedInformation)} />
	        					</div>
	        				}

	        				{ this.renderPharmaceuticalForm(drug)}
	      
	        				{ this.renderDisease(drug) }
	        				
	        				{this.renderActiveSubstance(drug)}
	
	        			
		    	    			<div className="additional-information">
		    	    				{showAdditionalInfo &&
		    		    				<section>
		    		        				{this.renderIndicationGroup(drug)}
		    		        				
		    		        				{this.renderProductGroup(drug)}

		    		    					{this.renderPZN(drug)}
		    		    				</section>
		    	    				}

		    	    				<p>
			    	    				<a onClick={this.toggleShowAdditionalInfo}>
			    	    					[{!showAdditionalInfo && <span>{t('viewDetails')}</span> }
			    	    					{showAdditionalInfo && <span>{t('hideDetails')}</span> }]
			    	    				</a>
		    	    				</p>
		    	    			</div>
	        				
	        			</div>
	        		</div>
	    			
	    			
	        		<hr />
	        		
	        		{this.renderSectionList(drug)}
	
	        	</div>
        );
    }
}

export default translate()(DrugDetail);