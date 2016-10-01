package kr.ac.hanyang.oCamp.rest.transform;

import java.util.List;

import org.apache.brooklyn.api.internal.AbstractBrooklynObjectSpec;
import org.apache.brooklyn.api.typereg.RegisteredType;
import org.apache.brooklyn.api.typereg.RegisteredTypeLoadingContext;
import org.apache.brooklyn.core.typereg.AbstractTypePlanTransformer;
import org.apache.brooklyn.util.exceptions.Exceptions;

public class OCampTypePlanTransformer extends AbstractTypePlanTransformer {

	protected OCampTypePlanTransformer(String format, String formatName, String formatDescription) {
		super(format, formatName, formatDescription);
	}

	@Override
	public double scoreForTypeDefinition(String formatCode, Object catalogData) {
		return 0;
	}

	@Override
	public List<RegisteredType> createFromTypeDefinition(String formatCode, Object catalogData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected double scoreForNullFormat(Object planData, RegisteredType type, RegisteredTypeLoadingContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected double scoreForNonmatchingNonnullFormat(String planFormat, Object planData, RegisteredType type,
			RegisteredTypeLoadingContext context) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected AbstractBrooklynObjectSpec<?, ?> createSpec(RegisteredType type, RegisteredTypeLoadingContext context) throws Exception {
		try { 
            AbstractBrooklynObjectSpec<?, ?> result = createSpec(type, context);
            // see notes on catalogItemIdIfNotNull
            result.catalogItemIdIfNotNull(type.getId());
            return result;
        } catch (Exception e) { throw Exceptions.propagate(e); }
	}

	@Override
	protected Object createBean(RegisteredType type, RegisteredTypeLoadingContext context) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
