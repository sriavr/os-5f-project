
/* First created by JCasGen Fri Apr 12 21:19:29 IST 2013 */
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

/** 
 * Updated by JCasGen Sun Apr 14 23:30:43 IST 2013
 * @generated */
public class EmailAnnotation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (EmailAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = EmailAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new EmailAnnotation(addr, EmailAnnotation_Type.this);
  			   EmailAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new EmailAnnotation(addr, EmailAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = EmailAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("annotation.EmailAnnotation");
 
  /** @generated */
  final Feature casFeat_sentOrReceived;
  /** @generated */
  final int     casFeatCode_sentOrReceived;
  /** @generated */ 
  public boolean getSentOrReceived(int addr) {
        if (featOkTst && casFeat_sentOrReceived == null)
      jcas.throwFeatMissing("sentOrReceived", "annotation.EmailAnnotation");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_sentOrReceived);
  }
  /** @generated */    
  public void setSentOrReceived(int addr, boolean v) {
        if (featOkTst && casFeat_sentOrReceived == null)
      jcas.throwFeatMissing("sentOrReceived", "annotation.EmailAnnotation");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_sentOrReceived, v);}
    
  
 
  /** @generated */
  final Feature casFeat_folderName;
  /** @generated */
  final int     casFeatCode_folderName;
  /** @generated */ 
  public String getFolderName(int addr) {
        if (featOkTst && casFeat_folderName == null)
      jcas.throwFeatMissing("folderName", "annotation.EmailAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_folderName);
  }
  /** @generated */    
  public void setFolderName(int addr, String v) {
        if (featOkTst && casFeat_folderName == null)
      jcas.throwFeatMissing("folderName", "annotation.EmailAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_folderName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_category;
  /** @generated */
  final int     casFeatCode_category;
  /** @generated */ 
  public String getCategory(int addr) {
        if (featOkTst && casFeat_category == null)
      jcas.throwFeatMissing("category", "annotation.EmailAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_category);
  }
  /** @generated */    
  public void setCategory(int addr, String v) {
        if (featOkTst && casFeat_category == null)
      jcas.throwFeatMissing("category", "annotation.EmailAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_category, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public EmailAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sentOrReceived = jcas.getRequiredFeatureDE(casType, "sentOrReceived", "uima.cas.Boolean", featOkTst);
    casFeatCode_sentOrReceived  = (null == casFeat_sentOrReceived) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentOrReceived).getCode();

 
    casFeat_folderName = jcas.getRequiredFeatureDE(casType, "folderName", "uima.cas.String", featOkTst);
    casFeatCode_folderName  = (null == casFeat_folderName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_folderName).getCode();

 
    casFeat_category = jcas.getRequiredFeatureDE(casType, "category", "uima.cas.String", featOkTst);
    casFeatCode_category  = (null == casFeat_category) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_category).getCode();

  }
}



    