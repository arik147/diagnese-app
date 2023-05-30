import express from "express";

// import galleriesController from '../controllers/galleries.controller.js';
import symptomController from "../controllers/symptom.controller.js";

const router =  express.Router();

/* galleries */
// router.post('/v1/galleries', galleriesController.create);
// router.get('/v1/galleries', galleriesController.get);

/* predict symptom */
router.post('/predict', symptomController.create);


export default router;