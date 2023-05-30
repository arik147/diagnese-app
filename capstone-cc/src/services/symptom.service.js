// import { v4 as uuidv4 } from 'uuid';
// import { Galleries } from "../models/galleries.model.js";

import * as tf from '@tensorflow/tfjs';

async function predictSymptom(request){

  // Get request Body
//   const { title, description } = request.body

  // const imageUrl = request.file.path
  
  // Error message
//   if (!title || !description) {
//     let message = ""
    
//       if (!title ) {
//         message += ", title"
//       }
      
//       // if (!imageUrl) {

//       //   message += ", imageUrl"
//       // }

//       if (!description) {
//         message += ", description"
//       }
    
//       return { 
//         status: 'Failed',
//         code: 400,
//         message: `Failed creating gallery${message} is empty!`
//       }
//     }
    
    try {
      

      const model = await tf.loadLayersModel('https://storage.googleapis.com/diagnese-capstone/model.json');

      const result = model.predict(inputData);

      console.log(result);

      // Return the newly created gallery in the response
      return {
        status: "success",
        code: 201,
        message: 'Predicting Symptom successfully!',
        data: newGallery
      }
    
  } catch (err) {
    console.error(err);
    return {
      status: "Failed", 
      code : 400,
      message : 'Error Predicting Symptom!'
    }
  }
}

export default {
    predictSymptom
}