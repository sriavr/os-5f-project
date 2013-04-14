
/* First created by JCasGen Fri Apr 12 21:25:36 IST 2013 */
package annotation;

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

/** Related to attachments
 * Updated by JCasGen Sun Apr 14 23:30:42 IST 2013
 * @generated */
public class AttachmentAnnotation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (AttachmentAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = AttachmentAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new AttachmentAnnotation(addr, AttachmentAnnotation_Type.this);
  			   AttachmentAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new AttachmentAnnotation(addr, AttachmentAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AttachmentAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("annotation.AttachmentAnnotation");
 
  /** @generated */
  final Feature casFeat_hasAttachment;
  /** @generated */
  final int     casFeatCode_hasAttachment;
  /** @generated */ 
  public boolean getHasAttachment(int addr) {
        if (featOkTst && casFeat_hasAttachment == null)
      jcas.throwFeatMissing("hasAttachment", "annotation.AttachmentAnnotation");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_hasAttachment);
  }
  /** @generated */    
  public void setHasAttachment(int addr, boolean v) {
        if (featOkTst && casFeat_hasAttachment == null)
      jcas.throwFeatMissing("hasAttachment", "annotation.AttachmentAnnotation");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_hasAttachment, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public AttachmentAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_hasAttachment = jcas.getRequiredFeatureDE(casType, "hasAttachment", "uima.cas.Boolean", featOkTst);
    casFeatCode_hasAttachment  = (null == casFeat_hasAttachment) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_hasAttachment).getCode();

  }
}



    