import React, { useEffect } from 'react';
import { useDispatch, useSelector } from "react-redux";
import { getMovies } from "../actions/movie";
import { Container } from "@mui/material";
import MovieCard from "./MovieCard";

const Movies = () => {

  const dispatch = useDispatch()
  const movies = useSelector(state => state.movieReducer.movies)

  useEffect(() => {
    if (movies.length === 0) {
      dispatch(getMovies())
    }
  }, [])



  return (
    <Container sx={{display: 'flex', flexWrap: 'wrap' }}>
      {movies.map(movie => <MovieCard rank={movie.rank} title={movie.title} rating={movie.rating} image={movie.image} description={movie.description} genre={movie.genre} imdbid={movie.imdbid}/> )}
    </Container>
  );
};

export default Movies;