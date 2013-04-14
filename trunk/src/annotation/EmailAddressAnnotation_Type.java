
/* First created by JCasGen Fri Apr 12 21:36:27 IST 2013 */
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

/** to store annotation related to email.
 * Updated by JCasGen Sun Apr 14 23:30:43 IST 2013
 * @generated */
public class EmailAddressAnnotation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (EmailAddressAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = EmailAddressAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new EmailAddressAnnotation(addr, EmailAddressAnnotation_Type.this);
  			   EmailAddressAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new EmailAddressAnnotation(addr, EmailAddressAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = EmailAddressAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("annotation.EmailAddressAnnotation");
 
  /** @generated */
  final Feature casFeat_senderEmail;
  /** @generated */
  final int     casFeatCode_senderEmail;
  /** @generated */ 
  public String getSenderEmail(int addr) {
        if (featOkTst && casFeat_senderEmail == null)
      jcas.throwFeatMissing("senderEmail", "annotation.EmailAddressAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_senderEmail);
  }
  /** @generated */    
  public void setSenderEmail(int addr, String v) {
        if (featOkTst && casFeat_senderEmail == null)
      jcas.throwFeatMissing("senderEmail", "annotation.EmailAddressAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_senderEmail, v);}
    
  
 
  /** @generated */
  final Feature casFeat_recepientEmail;
  /** @generated */
  final int     casFeatCode_recepientEmail;
  /** @generated */ 
  public int getRecepientEmail(int addr) {
        if (featOkTst && casFeat_recepientEmail == null)
      jcas.throwFeatMissing("recepientEmail", "annotation.EmailAddressAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_recepientEmail);
  }
  /** @generated */    
  public void setRecepientEmail(int addr, int v) {
        if (featOkTst && casFeat_recepientEmail == null)
      jcas.throwFeatMissing("recepientEmail", "annotation.EmailAddressAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_recepientEmail, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public EmailAddressAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_senderEmail = jcas.getRequiredFeatureDE(casType, "senderEmail", "uima.cas.String", featOkTst);
    casFeatCode_senderEmail  = (null == casFeat_senderEmail) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_senderEmail).getCode();

 
    casFeat_recepientEmail = jcas.getRequiredFeatureDE(casType, "recepientEmail", "uima.cas.StringList", featOkTst);
    casFeatCode_recepientEmail  = (null == casFeat_recepientEmail) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_recepientEmail).getCode();

  }
}



    