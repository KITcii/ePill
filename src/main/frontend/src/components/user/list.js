import axios from "axios";
import React from "react";

import {Link} from "react-router-dom";

import {translate} from "react-i18next";

// See https://facebook.github.io/react/docs/forms.html for documentation List forms.
class UserList extends React.Component {
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
        	        <h3>{t("userList")}</h3>
        	    </div>
        		
        	</div>
        );
    }
}

export default translate()(UserList);