package de.uniks.networkparser;

import de.uniks.networkparser.buffer.Tokener;
import de.uniks.networkparser.interfaces.Entity;
import de.uniks.networkparser.interfaces.Grammar;
import de.uniks.networkparser.interfaces.ObjectCondition;
import de.uniks.networkparser.json.JsonTokener;

public class EPILLIdMap extends IdMap implements ObjectCondition {

	public EPILLIdMap() {
		Grammar grammar = getGrammar();
		if(grammar instanceof SimpleGrammar) {
			SimpleGrammar sg = (SimpleGrammar) grammar;
			sg.withoutBasicFeature(IdMap.SESSION, IdMap.CLASS);
		}
	}
	
	@Override
	protected
	Entity encode(Object entity, MapEntity map, Tokener tokener) {
		if(tokener == null) {
			tokener = new JsonTokener().withMap(this);
		}
		if(map == null || map instanceof EPILLMapEntity == false) {
			if (entity !=null) {
				
				map = new EPILLMapEntity(getFilter(), FLAG_ID, this);
				map.withFlag(FLAG_ID);
			}
		}
		return super.encode(entity, map, tokener);
	}

	@Override
	public boolean update(Object value) {
		if(value instanceof SimpleEvent)  {
			return checkRegard((SimpleEvent)value);
		}
		return false;
	}
	
	public boolean checkRegard(SimpleEvent event) {
		//event.
		return false;
	}
}
