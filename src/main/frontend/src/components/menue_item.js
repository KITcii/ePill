import React from "react";

import {Link} from "react-router-dom";
import {translate} from "react-i18next";

import User from "./../util/User";

class MenueItem extends React.Component {
	  render() {
	    const {t} = this.props;
	    return (
	    		<li><Link to={this.props.to} data-toggle="collapse" data-target=".nav-collapse">{t(this.props.title)}</Link></li>
	    );
	  }
	}

export default translate()(MenueItem);