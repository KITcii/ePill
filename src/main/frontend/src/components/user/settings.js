import axios from "axios";
import React from "react";

import {Link} from "react-router-dom";

import {translate} from "react-i18next";

// See https://facebook.github.io/react/docs/forms.html for documentation about forms.
class About extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
        		
        };

    }

    render() {
        const {t} = this.props;

        return (
        	<div className="container marketing no-banner">
        		<div className='page-header'>
        	        <h3>{t("userSettings")}</h3>
        	    </div>
        		
        	</div>
        );
    }
}

export default translate()(About);