package de.uniks.networkparser;

import de.uniks.networkparser.buffer.CharacterBuffer;
import de.uniks.networkparser.buffer.Tokener;
import de.uniks.networkparser.interfaces.BaseItem;
import de.uniks.networkparser.interfaces.Entity;
import de.uniks.networkparser.interfaces.SendableEntityCreator;

public class EPILLMapEntity extends MapEntity{

	public EPILLMapEntity(Filter filter, byte flag, IdMap map) {
		super(filter, flag, map);
	}

	String getClassName(String className)  {
		int pos = className.indexOf("_$$");
		if(pos>0) {
			className = className.substring(0, pos);
		}

		return className;
	}
	@Override
		public String getId(Object entity, String className) {
			return super.getId(entity, getClassName(className));
		}
	
	
	@Override
		public Entity writeBasicValue(SendableEntityCreator creator, Entity entity, BaseItem parent, String className,
				String id) {
			return super.writeBasicValue(creator, entity, parent, getClassName(className), id);
		}
	
	 /*@Override
		public Object getNewEntity(SendableEntityCreator creator, String className, boolean prototype) {
			return super.getNewEntity(creator, getClassName(className), prototype);
		}
	 */
	 @Override
		public CharacterBuffer getPrefixProperties(SendableEntityCreator creator, Object entity,
				String className) {
			return super.getPrefixProperties(creator, entity, getClassName(className));
		}
	 /*
	 @Override
		public boolean isId(Object entity, String className) {
			return super.isId(entity, getClassName(className));
		}
		*/
}
