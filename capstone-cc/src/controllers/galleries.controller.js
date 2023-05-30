import galleries from "../services/galleries.service.js";

const get = async (req, res, next) => {
  try {
    res.json(await galleries.getMultiple());
  } catch (err) {
      console.error(`Error while getting galleries`, err.message);
      next(err);
  }
}


const create = async (req, res, next) => {
  try {
    // Create data to DB
    const data = await galleries.createGalleries(req);
    // if Return "Created / 201"
    if (data.code === 201)
    {
      // send response
      return res.status(201).json(data);
    }
    // return Error
    return res.status(400).json(data);
  } catch (err) {
    console.error(`Error while creating gallery`, err.message);
    next(err);
  }
}

export default {
  get,
  create
}