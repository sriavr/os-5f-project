
/* First created by JCasGen Fri Apr 12 21:39:05 IST 2013 */
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

/** This is for recognition of Name Entity Recognition whether it is Money or Person or Organization
 * Updated by JCasGen Sun Apr 14 23:30:43 IST 2013
 * @generated */
public class NERAnnotation_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (NERAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = NERAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new NERAnnotation(addr, NERAnnotation_Type.this);
  			   NERAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new NERAnnotation(addr, NERAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NERAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("annotation.NERAnnotation");
 
  /** @generated */
  final Feature casFeat_NERtype;
  /** @generated */
  final int     casFeatCode_NERtype;
  /** @generated */ 
  public String getNERtype(int addr) {
        if (featOkTst && casFeat_NERtype == null)
      jcas.throwFeatMissing("NERtype", "annotation.NERAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_NERtype);
  }
  /** @generated */    
  public void setNERtype(int addr, String v) {
        if (featOkTst && casFeat_NERtype == null)
      jcas.throwFeatMissing("NERtype", "annotation.NERAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_NERtype, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public NERAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_NERtype = jcas.getRequiredFeatureDE(casType, "NERtype", "uima.cas.String", featOkTst);
    casFeatCode_NERtype  = (null == casFeat_NERtype) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_NERtype).getCode();

  }
}



    