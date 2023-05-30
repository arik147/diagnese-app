import symptomService from "../services/symptom.service";

const create = async (req, res, next) => {
  try {
    // Create data to DB
    const data = await symptomService.predictSymptom(req);
    // if Return "Created / 201"
    if (data.code === 201)
    {
      // send response
      return res.status(201).json(data);
    }
    // return Error
    return res.status(400).json(data);
  } catch (err) {
    console.error(`Error while predicting symptom!`, err.message);
    next(err);
  }
}

export default {
  create
}