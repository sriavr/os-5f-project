
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

/** This is to store the email's sent or received time and date. This would be used for further processing of the email like generating statistics.
 * Updated by JCasGen Sun Apr 14 23:30:43 IST 2013
 * @generated */
public class DateTimeAnnotation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DateTimeAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DateTimeAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DateTimeAnnotation(addr, DateTimeAnnotation_Type.this);
  			   DateTimeAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DateTimeAnnotation(addr, DateTimeAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DateTimeAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("annotation.DateTimeAnnotation");
 
  /** @generated */
  final Feature casFeat_emailSentDateTime;
  /** @generated */
  final int     casFeatCode_emailSentDateTime;
  /** @generated */ 
  public String getEmailSentDateTime(int addr) {
        if (featOkTst && casFeat_emailSentDateTime == null)
      jcas.throwFeatMissing("emailSentDateTime", "annotation.DateTimeAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_emailSentDateTime);
  }
  /** @generated */    
  public void setEmailSentDateTime(int addr, String v) {
        if (featOkTst && casFeat_emailSentDateTime == null)
      jcas.throwFeatMissing("emailSentDateTime", "annotation.DateTimeAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_emailSentDateTime, v);}
    
  
 
  /** @generated */
  final Feature casFeat_emailReceivedDateTime;
  /** @generated */
  final int     casFeatCode_emailReceivedDateTime;
  /** @generated */ 
  public String getEmailReceivedDateTime(int addr) {
        if (featOkTst && casFeat_emailReceivedDateTime == null)
      jcas.throwFeatMissing("emailReceivedDateTime", "annotation.DateTimeAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_emailReceivedDateTime);
  }
  /** @generated */    
  public void setEmailReceivedDateTime(int addr, String v) {
        if (featOkTst && casFeat_emailReceivedDateTime == null)
      jcas.throwFeatMissing("emailReceivedDateTime", "annotation.DateTimeAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_emailReceivedDateTime, v);}
    
  
 
  /** @generated */
  final Feature casFeat_adjectives;
  /** @generated */
  final int     casFeatCode_adjectives;
  /** @generated */ 
  public int getAdjectives(int addr) {
        if (featOkTst && casFeat_adjectives == null)
      jcas.throwFeatMissing("adjectives", "annotation.DateTimeAnnotation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_adjectives);
  }
  /** @generated */    
  public void setAdjectives(int addr, int v) {
        if (featOkTst && casFeat_adjectives == null)
      jcas.throwFeatMissing("adjectives", "annotation.DateTimeAnnotation");
    ll_cas.ll_setIntValue(addr, casFeatCode_adjectives, v);}
    
  
 
  /** @generated */
  final Feature casFeat_nouns;
  /** @generated */
  final int     casFeatCode_nouns;
  /** @generated */ 
  public int getNouns(int addr) {
        if (featOkTst && casFeat_nouns == null)
      jcas.throwFeatMissing("nouns", "annotation.DateTimeAnnotation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_nouns);
  }
  /** @generated */    
  public void setNouns(int addr, int v) {
        if (featOkTst && casFeat_nouns == null)
      jcas.throwFeatMissing("nouns", "annotation.DateTimeAnnotation");
    ll_cas.ll_setIntValue(addr, casFeatCode_nouns, v);}
    
  
 
  /** @generated */
  final Feature casFeat_verbs;
  /** @generated */
  final int     casFeatCode_verbs;
  /** @generated */ 
  public int getVerbs(int addr) {
        if (featOkTst && casFeat_verbs == null)
      jcas.throwFeatMissing("verbs", "annotation.DateTimeAnnotation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_verbs);
  }
  /** @generated */    
  public void setVerbs(int addr, int v) {
        if (featOkTst && casFeat_verbs == null)
      jcas.throwFeatMissing("verbs", "annotation.DateTimeAnnotation");
    ll_cas.ll_setIntValue(addr, casFeatCode_verbs, v);}
    
  
 
  /** @generated */
  final Feature casFeat_adverbs;
  /** @generated */
  final int     casFeatCode_adverbs;
  /** @generated */ 
  public int getAdverbs(int addr) {
        if (featOkTst && casFeat_adverbs == null)
      jcas.throwFeatMissing("adverbs", "annotation.DateTimeAnnotation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_adverbs);
  }
  /** @generated */    
  public void setAdverbs(int addr, int v) {
        if (featOkTst && casFeat_adverbs == null)
      jcas.throwFeatMissing("adverbs", "annotation.DateTimeAnnotation");
    ll_cas.ll_setIntValue(addr, casFeatCode_adverbs, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public DateTimeAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_emailSentDateTime = jcas.getRequiredFeatureDE(casType, "emailSentDateTime", "uima.cas.String", featOkTst);
    casFeatCode_emailSentDateTime  = (null == casFeat_emailSentDateTime) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_emailSentDateTime).getCode();

 
    casFeat_emailReceivedDateTime = jcas.getRequiredFeatureDE(casType, "emailReceivedDateTime", "uima.cas.String", featOkTst);
    casFeatCode_emailReceivedDateTime  = (null == casFeat_emailReceivedDateTime) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_emailReceivedDateTime).getCode();

 
    casFeat_adjectives = jcas.getRequiredFeatureDE(casType, "adjectives", "uima.cas.Integer", featOkTst);
    casFeatCode_adjectives  = (null == casFeat_adjectives) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_adjectives).getCode();

 
    casFeat_nouns = jcas.getRequiredFeatureDE(casType, "nouns", "uima.cas.Integer", featOkTst);
    casFeatCode_nouns  = (null == casFeat_nouns) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_nouns).getCode();

 
    casFeat_verbs = jcas.getRequiredFeatureDE(casType, "verbs", "uima.cas.Integer", featOkTst);
    casFeatCode_verbs  = (null == casFeat_verbs) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_verbs).getCode();

 
    casFeat_adverbs = jcas.getRequiredFeatureDE(casType, "adverbs", "uima.cas.Integer", featOkTst);
    casFeatCode_adverbs  = (null == casFeat_adverbs) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_adverbs).getCode();

  }
}



    