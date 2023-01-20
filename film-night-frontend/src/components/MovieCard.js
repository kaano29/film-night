import * as React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { IconButton } from "@mui/material";
import { FavoriteBorder } from "@mui/icons-material";

export default function MovieCard(props) {
  return (
    <Card sx={{ maxWidth: '30%', m: 2 }}>
      <CardMedia
        sx={{ height: 350 }}
        image={props.image}
        title="green iguana"
      />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
          {props.title}
        </Typography>
        <Typography variant="body3" color="text.secondary">
          {props.description}
        </Typography>
        <Typography variant="body2" color="text.primary">
          Genre: {props.genre}
        </Typography>
        <Typography variant="body2" color="text.primary">
          Rating: {props.rating}
        </Typography>
      </CardContent>
      <CardActions>
        <IconButton aria-label="favorite" color="primary">
          <FavoriteBorder />
        </IconButton>
        <Button size="small">Learn More</Button>
      </CardActions>
    </Card>
  );
}