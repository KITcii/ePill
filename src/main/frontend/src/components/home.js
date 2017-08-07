import React from "react";

import {translate} from "react-i18next";

import Carousel from "./carousel";
import MostVisitedItems from "./most_visited_items";

import User from "./../util/User";

// See https://facebook.github.io/react/docs/forms.html for documentation about forms.
class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state = {

        };
    }

    render() {
        const {t} = this.props;

        return (
        		<div>
        		<Carousel />

        		<div className="container marketing">
        		
        			{User.isAuthenticated() &&
        				<MostVisitedItems />
        			}
        		
        			<div className="row">
        				<div className="col-lg-4">
        					<img className="img-circle" src="/assets/images/logo_s.svg" alt="Generic placeholder image" width="140" height="140"></img>
        					<h2>{t("projectName")}</h2>
        					<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis
        						euismod. Nullam id dolor id nibh ultricies vehicula ut id elit.
        						Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
        						Praesent commodo cursus magna.</p>
        					<p>
        						<a className="btn btn-default" href="/about" role="button" target="blank">{t('viewDetails')} »</a>
        					</p>
        				</div>
        				<div className="col-lg-4">
        					<img className="img-circle" src="/assets/images/prof_sunyaev.jpg" alt="Generic placeholder image" width="140" height="140"></img>
        					<h2>{t("Team")}</h2>
        					<p>Duis mollis, est non commodo luctus, nisi erat porttitor
        						ligula, eget lacinia odio sem nec elit. Cras mattis consectetur
        						purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo,
        						tortor mauris condimentum nibh.</p>
        					<p>
        						<a className="btn btn-default" href="https://www.uni-kassel.de/fb07/institute/ibwl/personen-fachgebiete/sunyaev-prof-dr/team.html" role="button" target="blank">{t('viewDetails')} »</a>
        					</p>
        				</div>

        				<div className="col-lg-4">
        					<img className="img-circle" src="/assets/images/articles.jpg" alt="Generic placeholder image" width="140" height="140"></img>
        					<h2>{t("articles")}</h2>
        					<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
        						egestas eget quam. Vestibulum id ligula porta felis euismod semper.
        						Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
        						nibh, ut fermentum massa justo sit amet risus.</p>
        					<p>
        						<a className="btn btn-default" href="https://www.uni-kassel.de/fb07/institute/ibwl/personen-fachgebiete/sunyaev-prof-dr/research.html" role="button" target="blank">{t('viewDetails')} »</a>
        					</p>
        				</div>
        			</div>
        		</div>
        	</div>     
        );
    }
}

export default translate()(Home);