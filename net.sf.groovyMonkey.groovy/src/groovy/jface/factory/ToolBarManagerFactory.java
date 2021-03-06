package groovy.jface.factory;
import groovy.swt.InvalidParentException;
import groovy.swt.factory.AbstractSwtFactory;
import groovy.swt.factory.SwtFactory;
import java.util.Map;
import org.codehaus.groovy.GroovyException;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.ui.forms.widgets.Form;

/**
 * @author <a href="mailto:ckl@dacelo.nl">Christiaan ten Klooster </a>
 * @version $Revision$
 */
public class ToolBarManagerFactory 
extends AbstractSwtFactory 
implements SwtFactory
{
    /*
     * @see groovy.swt.impl.SwtFactory#newInstance(java.util.Map,
     *      java.lang.Object)
     */
    @Override
    public Object newInstance( final Map<String,Object> properties, 
                               final Object parent ) 
    throws GroovyException
    {
        ToolBarManager toolBarManager = null;
        if( parent instanceof Form )
        {
            final Form form = ( Form )parent;
            toolBarManager = ( ToolBarManager )form.getToolBarManager();
        }
        if( parent instanceof ApplicationWindow )
        {
            final ApplicationWindow applicationWindow = ( ApplicationWindow )parent;
            toolBarManager = applicationWindow.getToolBarManager();
        }
        if( toolBarManager == null )
            throw new InvalidParentException( "<form> or <applicationWindow>" );
        return toolBarManager;
    }
}
