
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

/** parts of speech annotations
 * Updated by JCasGen Sun Apr 14 23:30:43 IST 2013
 * @generated */
public class POSAnnotation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (POSAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = POSAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new POSAnnotation(addr, POSAnnotation_Type.this);
  			   POSAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new POSAnnotation(addr, POSAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = POSAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("annotation.POSAnnotation");
 
  /** @generated */
  final Feature casFeat_posType;
  /** @generated */
  final int     casFeatCode_posType;
  /** @generated */ 
  public String getPosType(int addr) {
        if (featOkTst && casFeat_posType == null)
      jcas.throwFeatMissing("posType", "annotation.POSAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_posType);
  }
  /** @generated */    
  public void setPosType(int addr, String v) {
        if (featOkTst && casFeat_posType == null)
      jcas.throwFeatMissing("posType", "annotation.POSAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_posType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_adjectives;
  /** @generated */
  final int     casFeatCode_adjectives;
  /** @generated */ 
  public int getAdjectives(int addr) {
        if (featOkTst && casFeat_adjectives == null)
      jcas.throwFeatMissing("adjectives", "annotation.POSAnnotation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_adjectives);
  }
  /** @generated */    
  public void setAdjectives(int addr, int v) {
        if (featOkTst && casFeat_adjectives == null)
      jcas.throwFeatMissing("adjectives", "annotation.POSAnnotation");
    ll_cas.ll_setIntValue(addr, casFeatCode_adjectives, v);}
    
  
 
  /** @generated */
  final Feature casFeat_adverbs;
  /** @generated */
  final int     casFeatCode_adverbs;
  /** @generated */ 
  public int getAdverbs(int addr) {
        if (featOkTst && casFeat_adverbs == null)
      jcas.throwFeatMissing("adverbs", "annotation.POSAnnotation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_adverbs);
  }
  /** @generated */    
  public void setAdverbs(int addr, int v) {
        if (featOkTst && casFeat_adverbs == null)
      jcas.throwFeatMissing("adverbs", "annotation.POSAnnotation");
    ll_cas.ll_setIntValue(addr, casFeatCode_adverbs, v);}
    
  
 
  /** @generated */
  final Feature casFeat_nouns;
  /** @generated */
  final int     casFeatCode_nouns;
  /** @generated */ 
  public int getNouns(int addr) {
        if (featOkTst && casFeat_nouns == null)
      jcas.throwFeatMissing("nouns", "annotation.POSAnnotation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_nouns);
  }
  /** @generated */    
  public void setNouns(int addr, int v) {
        if (featOkTst && casFeat_nouns == null)
      jcas.throwFeatMissing("nouns", "annotation.POSAnnotation");
    ll_cas.ll_setIntValue(addr, casFeatCode_nouns, v);}
    
  
 
  /** @generated */
  final Feature casFeat_verbs;
  /** @generated */
  final int     casFeatCode_verbs;
  /** @generated */ 
  public int getVerbs(int addr) {
        if (featOkTst && casFeat_verbs == null)
      jcas.throwFeatMissing("verbs", "annotation.POSAnnotation");
    return ll_cas.ll_getIntValue(addr, casFeatCode_verbs);
  }
  /** @generated */    
  public void setVerbs(int addr, int v) {
        if (featOkTst && casFeat_verbs == null)
      jcas.throwFeatMissing("verbs", "annotation.POSAnnotation");
    ll_cas.ll_setIntValue(addr, casFeatCode_verbs, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public POSAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_posType = jcas.getRequiredFeatureDE(casType, "posType", "uima.cas.String", featOkTst);
    casFeatCode_posType  = (null == casFeat_posType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_posType).getCode();

 
    casFeat_adjectives = jcas.getRequiredFeatureDE(casType, "adjectives", "uima.cas.Integer", featOkTst);
    casFeatCode_adjectives  = (null == casFeat_adjectives) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_adjectives).getCode();

 
    casFeat_adverbs = jcas.getRequiredFeatureDE(casType, "adverbs", "uima.cas.Integer", featOkTst);
    casFeatCode_adverbs  = (null == casFeat_adverbs) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_adverbs).getCode();

 
    casFeat_nouns = jcas.getRequiredFeatureDE(casType, "nouns", "uima.cas.Integer", featOkTst);
    casFeatCode_nouns  = (null == casFeat_nouns) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_nouns).getCode();

 
    casFeat_verbs = jcas.getRequiredFeatureDE(casType, "verbs", "uima.cas.Integer", featOkTst);
    casFeatCode_verbs  = (null == casFeat_verbs) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_verbs).getCode();

  }
}



    