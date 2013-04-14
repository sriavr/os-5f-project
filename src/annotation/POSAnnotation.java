

/* First created by JCasGen Fri Apr 12 21:36:27 IST 2013 */
package annotation;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** parts of speech annotations
 * Updated by JCasGen Sun Apr 14 23:30:43 IST 2013
 * XML source: /home/sridhar/workspace/UIMAwebapp2/desc/emailTypeDescriptor.xml
 * @generated */
public class POSAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(POSAnnotation.class);
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
  protected POSAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public POSAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public POSAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public POSAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: posType

  /** getter for posType - gets based on parts of speech
   * @generated */
  public String getPosType() {
    if (POSAnnotation_Type.featOkTst && ((POSAnnotation_Type)jcasType).casFeat_posType == null)
      jcasType.jcas.throwFeatMissing("posType", "annotation.POSAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((POSAnnotation_Type)jcasType).casFeatCode_posType);}
    
  /** setter for posType - sets based on parts of speech 
   * @generated */
  public void setPosType(String v) {
    if (POSAnnotation_Type.featOkTst && ((POSAnnotation_Type)jcasType).casFeat_posType == null)
      jcasType.jcas.throwFeatMissing("posType", "annotation.POSAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((POSAnnotation_Type)jcasType).casFeatCode_posType, v);}    
   
    
  //*--------------*
  //* Feature: adjectives

  /** getter for adjectives - gets 
   * @generated */
  public int getAdjectives() {
    if (POSAnnotation_Type.featOkTst && ((POSAnnotation_Type)jcasType).casFeat_adjectives == null)
      jcasType.jcas.throwFeatMissing("adjectives", "annotation.POSAnnotation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((POSAnnotation_Type)jcasType).casFeatCode_adjectives);}
    
  /** setter for adjectives - sets  
   * @generated */
  public void setAdjectives(int v) {
    if (POSAnnotation_Type.featOkTst && ((POSAnnotation_Type)jcasType).casFeat_adjectives == null)
      jcasType.jcas.throwFeatMissing("adjectives", "annotation.POSAnnotation");
    jcasType.ll_cas.ll_setIntValue(addr, ((POSAnnotation_Type)jcasType).casFeatCode_adjectives, v);}    
   
    
  //*--------------*
  //* Feature: adverbs

  /** getter for adverbs - gets 
   * @generated */
  public int getAdverbs() {
    if (POSAnnotation_Type.featOkTst && ((POSAnnotation_Type)jcasType).casFeat_adverbs == null)
      jcasType.jcas.throwFeatMissing("adverbs", "annotation.POSAnnotation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((POSAnnotation_Type)jcasType).casFeatCode_adverbs);}
    
  /** setter for adverbs - sets  
   * @generated */
  public void setAdverbs(int v) {
    if (POSAnnotation_Type.featOkTst && ((POSAnnotation_Type)jcasType).casFeat_adverbs == null)
      jcasType.jcas.throwFeatMissing("adverbs", "annotation.POSAnnotation");
    jcasType.ll_cas.ll_setIntValue(addr, ((POSAnnotation_Type)jcasType).casFeatCode_adverbs, v);}    
   
    
  //*--------------*
  //* Feature: nouns

  /** getter for nouns - gets 
   * @generated */
  public int getNouns() {
    if (POSAnnotation_Type.featOkTst && ((POSAnnotation_Type)jcasType).casFeat_nouns == null)
      jcasType.jcas.throwFeatMissing("nouns", "annotation.POSAnnotation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((POSAnnotation_Type)jcasType).casFeatCode_nouns);}
    
  /** setter for nouns - sets  
   * @generated */
  public void setNouns(int v) {
    if (POSAnnotation_Type.featOkTst && ((POSAnnotation_Type)jcasType).casFeat_nouns == null)
      jcasType.jcas.throwFeatMissing("nouns", "annotation.POSAnnotation");
    jcasType.ll_cas.ll_setIntValue(addr, ((POSAnnotation_Type)jcasType).casFeatCode_nouns, v);}    
   
    
  //*--------------*
  //* Feature: verbs

  /** getter for verbs - gets 
   * @generated */
  public int getVerbs() {
    if (POSAnnotation_Type.featOkTst && ((POSAnnotation_Type)jcasType).casFeat_verbs == null)
      jcasType.jcas.throwFeatMissing("verbs", "annotation.POSAnnotation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((POSAnnotation_Type)jcasType).casFeatCode_verbs);}
    
  /** setter for verbs - sets  
   * @generated */
  public void setVerbs(int v) {
    if (POSAnnotation_Type.featOkTst && ((POSAnnotation_Type)jcasType).casFeat_verbs == null)
      jcasType.jcas.throwFeatMissing("verbs", "annotation.POSAnnotation");
    jcasType.ll_cas.ll_setIntValue(addr, ((POSAnnotation_Type)jcasType).casFeatCode_verbs, v);}    
  }

    