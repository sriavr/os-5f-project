

/* First created by JCasGen Fri Apr 12 21:39:05 IST 2013 */
package annotation;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** This is for recognition of Name Entity Recognition whether it is Money or Person or Organization
 * Updated by JCasGen Sun Apr 14 23:30:43 IST 2013
 * XML source: /home/sridhar/workspace/UIMAwebapp2/desc/emailTypeDescriptor.xml
 * @generated */
public class NERAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NERAnnotation.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected NERAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public NERAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public NERAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public NERAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: NERtype

  /** getter for NERtype - gets Either it is Person or Organization or Name
   * @generated */
  public String getNERtype() {
    if (NERAnnotation_Type.featOkTst && ((NERAnnotation_Type)jcasType).casFeat_NERtype == null)
      jcasType.jcas.throwFeatMissing("NERtype", "annotation.NERAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NERAnnotation_Type)jcasType).casFeatCode_NERtype);}
    
  /** setter for NERtype - sets Either it is Person or Organization or Name 
   * @generated */
  public void setNERtype(String v) {
    if (NERAnnotation_Type.featOkTst && ((NERAnnotation_Type)jcasType).casFeat_NERtype == null)
      jcasType.jcas.throwFeatMissing("NERtype", "annotation.NERAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((NERAnnotation_Type)jcasType).casFeatCode_NERtype, v);}    
  }

    