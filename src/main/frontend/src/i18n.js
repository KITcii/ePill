import i18n from "i18next";
import XHR from "i18next-xhr-backend";
import LngDetector from 'i18next-browser-languagedetector';

// See https://www.i18next.com/ for a LOT of documentation.

i18n
    .use(XHR)
    .use(LngDetector)
    .init({
    	
    		detection: {
			// order and from where user language should be detected
			order: ['querystring', 'cookie', 'navigator', 'localStorage', 'htmlTag'],

			// keys or params to lookup language from
			lookupQuerystring: 'language',
			lookupCookie: 'language',
			lookupLocalStorage: 'language',

			// cache user language on
			caches: ['cookie'],

			// optional expire and domain for set cookie
			cookieMinutes: 60*24*365,
		},
    	
		//suppress 404 warnings
		whitelist	: ['de', 'en'],
        fallbackLng	: 'de',

        // Have a common namespace used around the full app
        nsSeparator: false,
		keySeparator: false,
        ns: ['common'],	
        defaultNS: 'common',

        debug: false,

        interpolation: {
			escapeValue: false // not needed for react!!
		},

		backend: {
			loadPath: "/locales/{{lng}}/{{ns}}.json"
		}
    });

export default i18n;