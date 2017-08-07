import React from "react";

import {translate} from "react-i18next";

import User from "./../util/User";


class Footer extends React.Component {
	  constructor(props) {
	    super(props);
	    this.status = {
	    		show		: false
	    }

	    this.toggleShow = this.toggleShow.bind(this);
	  }

	  toggleShow(event) {
		  this.status.show = !this.status.show;
		  this.setState(this.status);
	  }
	  
	  render() {

	      const {t} = this.props;
	      const show = this.status.show;
		  
		  return (
				  <footer className="footer">
					<div className="container">
						<div className="row bottom-rule">
							<div className="col-sm-4 footer-section">
								<strong>Connect with us</strong>
								<p>Email</p>
								<form className="form-inline">
									<div className="form-group">
										<label className="sr-only" htmlFor="inputEmail">{t("email")}</label> <input
											type="email" className="form-control" id="inputEmail"
											placeholder="address@example.com" />
									</div>
									<button type="submit" className="btn btn-default">{t('subscribe')}</button>
								</form>
							</div>
							<div className="col-sm-5 footer-section">
								<ul className="list-inline">
									<li className="text-uppercase">ePill:</li>
									<li><a href="https://www.uni-kassel.de/fb07/institute/ibwl/personen-fachgebiete/sunyaev-prof-dr/team.html" target="blank">{t("team")}</a></li>
									<li><a href="https://www.uni-kassel.de/fb07/institute/ibwl/personen-fachgebiete/sunyaev-prof-dr/research.html" target="blank">{t("articles")}</a></li>
									<li><a href="#/about">{t('whyRegister')}</a></li>
								</ul>
								<ul className="list-inline">
									<li className="text-uppercase">{t("help")}:</li>
									<li><a href="#/sitemap">{t("functions")}</a></li>
									<li><a href="#/privacy">{t("privacy")}</a></li>
								</ul>
							</div>
							<div className="col-sm-3">
								<address>
									<strong>Universität Kassel</strong><br /> Henschelstraße 4<br />
									34127, Kassel<br /> (+49) 561-804-3450<br />
									<a href="mailto:sunyaev@uni-kassel.de">{t("contactUs")}</a>
								</address>
							</div>
						</div>
						<div className="row bottom-rule">
							<div className="col-sm-12">
								<nav className="navbar navbar-default navbar-footer">
									<ul className="nav navbar-nav">
										<li><a href="#">{t("customerCare")}</a></li>
										<li><a href="#">{t("news")}</a></li>
										<li><a href="#/imprint">{t("imprint")}</a></li>
									</ul>
								</nav>
							</div>
						</div>
						<div className="row leg-room">
							<div className="col-md-12 text-center">
								<h3 className="text-uppercase">ePill</h3>
								<p className="monospaced">
									&copy;2017 ePill <span className="text-uppercase">All Rights Reserved</span>
								</p>
							</div>
						</div>
					</div>
				</footer>
		  );
	  }
}

export default translate()(Footer);