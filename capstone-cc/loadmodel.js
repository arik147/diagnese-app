// // import { loadModel, convertModelToJSON } from 'tensorflowjs-converter';

// import * as tf from '@tensorflow/tfjs';
// import '@tensorflow/tfjs-node';
// import * as tfjsConverter from '@tensorflow/tfjs-converter';

// // Load the H5 model.
// // const model = tf.loadModel('../temp/model.h5');
// const model = await tf.loadLayersModel('localstorage://my-model-1');

// // Convert the model to JSON.
// const jsonModel = tf.convertModelToJSON(model);

// // Save the JSON model to a file.
// fs.writeFileSync('model.json', jsonModel);


// import { readFileSync } from 'fs';
// const modelJson = readFileSync('model/model.json', 'utf8');

// import * as tf from '@tensorflow/tfjs';

// const model = await tf.loadLayersModel('https://storage.googleapis.com/diagnese-capstone/model.json');

// const result = model.predict(inputData);

// console.log(result);