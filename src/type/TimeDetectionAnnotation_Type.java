
/* First created by JCasGen Fri Mar 22 18:43:39 IST 2013 */
package type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** This annotation marks whether current mail item is marked or not, and the time slot to which the email belongs to.
 * Updated by JCasGen Sat Mar 23 16:02:12 IST 2013
 * @generated */
public class TimeDetectionAnnotation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (TimeDetectionAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = TimeDetectionAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new TimeDetectionAnnotation(addr, TimeDetectionAnnotation_Type.this);
  			   TimeDetectionAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new TimeDetectionAnnotation(addr, TimeDetectionAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = TimeDetectionAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.TimeDetectionAnnotation");



  /** @generated */
  final Feature casFeat_selected;
  /** @generated */
  final int     casFeatCode_selected;
  /** @generated */ 
  public boolean getSelected(int addr) {
        if (featOkTst && casFeat_selected == null)
      jcas.throwFeatMissing("selected", "type.TimeDetectionAnnotation");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_selected);
  }
  /** @generated */    
  public void setSelected(int addr, boolean v) {
        if (featOkTst && casFeat_selected == null)
      jcas.throwFeatMissing("selected", "type.TimeDetectionAnnotation");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_selected, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timeSlot;
  /** @generated */
  final int     casFeatCode_timeSlot;
  /** @generated */ 
  public int getTimeSlot(int addr) {
        if (featOkTst && casFeat_timeSlot == null)
      jcas.throwFeatMissing("timeSlot", "type.TimeDetectionAnnotation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_timeSlot);
  }
  /** @generated */    
  public void setTimeSlot(int addr, int v) {
        if (featOkTst && casFeat_timeSlot == null)
      jcas.throwFeatMissing("timeSlot", "type.TimeDetectionAnnotation");
    ll_cas.ll_setIntValue(addr, casFeatCode_timeSlot, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public TimeDetectionAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_selected = jcas.getRequiredFeatureDE(casType, "selected", "uima.cas.Boolean", featOkTst);
    casFeatCode_selected  = (null == casFeat_selected) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_selected).getCode();

 
    casFeat_timeSlot = jcas.getRequiredFeatureDE(casType, "timeSlot", "uima.cas.Integer", featOkTst);
    casFeatCode_timeSlot  = (null == casFeat_timeSlot) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timeSlot).getCode();

  }
}



    