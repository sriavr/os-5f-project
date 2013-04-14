

/* First created by JCasGen Fri Apr 12 21:25:36 IST 2013 */
package annotation;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.StringList;
import org.apache.uima.jcas.tcas.Annotation;


/** This is to store the email's sent or received time and date. This would be used for further processing of the email like generating statistics.
 * Updated by JCasGen Sun Apr 14 23:30:43 IST 2013
 * XML source: /home/sridhar/workspace/UIMAwebapp2/desc/emailTypeDescriptor.xml
 * @generated */
public class DateTimeAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DateTimeAnnotation.class);
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
  protected DateTimeAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DateTimeAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DateTimeAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public DateTimeAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: emailSentDateTime

  /** getter for emailSentDateTime - gets Date time of the email sent or received
   * @generated */
  public String getEmailSentDateTime() {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_emailSentDateTime == null)
      jcasType.jcas.throwFeatMissing("emailSentDateTime", "annotation.DateTimeAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_emailSentDateTime);}
    
  /** setter for emailSentDateTime - sets Date time of the email sent or received 
   * @generated */
  public void setEmailSentDateTime(String v) {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_emailSentDateTime == null)
      jcasType.jcas.throwFeatMissing("emailSentDateTime", "annotation.DateTimeAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_emailSentDateTime, v);}    
   
    
  //*--------------*
  //* Feature: emailReceivedDateTime

  /** getter for emailReceivedDateTime - gets 
   * @generated */
  public String getEmailReceivedDateTime() {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_emailReceivedDateTime == null)
      jcasType.jcas.throwFeatMissing("emailReceivedDateTime", "annotation.DateTimeAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_emailReceivedDateTime);}
    
  /** setter for emailReceivedDateTime - sets  
   * @generated */
  public void setEmailReceivedDateTime(String v) {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_emailReceivedDateTime == null)
      jcasType.jcas.throwFeatMissing("emailReceivedDateTime", "annotation.DateTimeAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_emailReceivedDateTime, v);}    
   
    
  //*--------------*
  //* Feature: adjectives

  /** getter for adjectives - gets 
   * @generated */
  public int getAdjectives() {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_adjectives == null)
      jcasType.jcas.throwFeatMissing("adjectives", "annotation.DateTimeAnnotation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_adjectives);}
    
  /** setter for adjectives - sets  
   * @generated */
  public void setAdjectives(int v) {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_adjectives == null)
      jcasType.jcas.throwFeatMissing("adjectives", "annotation.DateTimeAnnotation");
    jcasType.ll_cas.ll_setIntValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_adjectives, v);}    
   
    
  //*--------------*
  //* Feature: nouns

  /** getter for nouns - gets 
   * @generated */
  public int getNouns() {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_nouns == null)
      jcasType.jcas.throwFeatMissing("nouns", "annotation.DateTimeAnnotation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_nouns);}
    
  /** setter for nouns - sets  
   * @generated */
  public void setNouns(int v) {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_nouns == null)
      jcasType.jcas.throwFeatMissing("nouns", "annotation.DateTimeAnnotation");
    jcasType.ll_cas.ll_setIntValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_nouns, v);}    
   
    
  //*--------------*
  //* Feature: verbs

  /** getter for verbs - gets 
   * @generated */
  public int getVerbs() {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_verbs == null)
      jcasType.jcas.throwFeatMissing("verbs", "annotation.DateTimeAnnotation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_verbs);}
    
  /** setter for verbs - sets  
   * @generated */
  public void setVerbs(int v) {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_verbs == null)
      jcasType.jcas.throwFeatMissing("verbs", "annotation.DateTimeAnnotation");
    jcasType.ll_cas.ll_setIntValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_verbs, v);}    
   
    
  //*--------------*
  //* Feature: adverbs

  /** getter for adverbs - gets 
   * @generated */
  public int getAdverbs() {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_adverbs == null)
      jcasType.jcas.throwFeatMissing("adverbs", "annotation.DateTimeAnnotation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_adverbs);}
    
  /** setter for adverbs - sets  
   * @generated */
  public void setAdverbs(int v) {
    if (DateTimeAnnotation_Type.featOkTst && ((DateTimeAnnotation_Type)jcasType).casFeat_adverbs == null)
      jcasType.jcas.throwFeatMissing("adverbs", "annotation.DateTimeAnnotation");
    jcasType.ll_cas.ll_setIntValue(addr, ((DateTimeAnnotation_Type)jcasType).casFeatCode_adverbs, v);}    
  }

    