import axios from "axios";
import React from "react";

import {translate} from "react-i18next";

import User from "../util/User";

class Carousel extends React.Component {
    constructor(props) {
        super();
        this.state = {
            drug: undefined
        }

    }

    generatePersonalizedAddress() {

        const {t} = this.props;
        var time = new Date().getHours(); 
    		var greeting = null;

    		switch(true) {
			case (time > 4 && time < 9):
				greeting = t("greetingMorning");
				break;
			case (time > 9 && time < 13):
				greeting = t("greetingNoon");
				break;
			case (time > 13 && time < 17):
				greeting = t("greetingHighNoon");
				break;
			case (time > 17 && time < 22):
				greeting = t("greetingEvening");
				break;
    			default:
    				greeting = t("greetingNight");
    		}
    	
    		return(<h1>{greeting.replace("%User.firstname%", User.firstname)}</h1>);
    }
    
    componentWillMount() {

    }

    render() {
        return (
        	<div id="landing-page-carousel" className="carousel slide">
        		<div className="carousel-inner" role="listbox">
        			<div className="item active">
        				<img className="first-slide" src="/assets/images/header1.png" alt="First slide"></img>
        				<div className="container">
        					{User.isAuthenticated() && 
        						<div className="carousel-caption">
	        						{this.generatePersonalizedAddress()}
	        					</div>
        					}
        				</div>
        			</div>
        		</div>
        	</div>
        );
    }
}

export default translate()(Carousel);