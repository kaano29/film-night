import axios from 'axios'

const API_URL = 'https://film-night-backend-1673962682438.azurewebsites.net/api/v1/movies'

export const getMoviesApi = async () => {
  try {
    const res = await axios.get(API_URL);
    return res;
  } catch (err) {
    throw err.response;
  }
}