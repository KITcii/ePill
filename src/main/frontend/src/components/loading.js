import axios from "axios";
import React from "react";

import {translate} from "react-i18next";
import { toast } from 'react-toastify';

import User from "./../util/User";


class Loading extends React.Component {
	  constructor(props) {
	    super(props);
	    
	    this.refresh	= this.props.refresh;

	  }

	  render() {
	      const {t} = this.props;
	        
		  return (
          		<div className="col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4 col-lg-4 col-lg-offset-4">
          			<p>{t('loading')}</p>
		    		</div>
             );
	  }
	}

export default translate()(Loading);