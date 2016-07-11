package kr.ac.hanyang.entities.artifacts.machine;

import org.apache.brooklyn.core.entity.trait.Startable;
import org.apache.brooklyn.entity.stock.EffectorStartableImpl;

public class Machine_Art<T> extends EffectorStartableImpl implements Startable{
	//private static final Logger log = LoggerFactory.getLogger(Machine_Art.class);
	
	private T content;
	
	boolean connectedSensors = false; // not sure if I need sensors as yet
	
	public Machine_Art(){
		super();
	}
	
	public void init(){
		super.init();
	}
	
	public void setContent(T content){
		this.content = content;
	}
	
	public T getContent(){
		return (T) this.content;
	}

//	@Override
//	protected BrooklynObjectInternal configure(Map<?, ?> flags) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
