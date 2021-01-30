import React, {
    useEffect,
    useState
} from "react";

import {
    makeStyles
} from '@material-ui/core/styles';

import TextField from '@material-ui/core/TextField';
import MenuItem from '@material-ui/core/MenuItem';

const useStyles = makeStyles((theme) => ({
  root: {
    '& .MuiTextField-root': {
      margin: theme.spacing(1),
      width: '25ch',
    },
  },
}));

function ReasonChoicePage() {
    const classes = useStyles();

    const [
        reasonChoiceModel, setReasonChoiceModel
    ] = useState({});

    const [
      doctors, setDoctors
    ] = useState([]);

    const [
      doctor, setDoctor
    ] = useState('3');

    useEffect(() => {
        fetch('/backend/get-reason-choice-model')
            .then(response => response.json())
            .then(result => {
              setReasonChoiceModel(result);
              setDoctors(updateDoctors(result.doctors));
            });
    }, []);

    const updateDoctors = doctorsFromModel => {
      return doctorsFromModel
        ? doctorsFromModel.map(getDoctorForSelect)
        : [];
    };

    const getDoctorForSelect = doctorFromModel => {
      return (
        {
          value: doctorFromModel?.id,
          label: doctorFromModel?.displayedName
        }
      );
    };

    const handleDoctorSelectChange = (event) => {
      console.log('event.target', event.target);
      console.log('doctor before', doctor);
      setDoctor(event.target.value);
    }

    return (
        <>
          <form className={classes.root} noValidate autoComplete="off">
            <div>
              <TextField
                id="standard-select-doctor"
                select
                label="Doctor"
                value={doctor}
                onChange={handleDoctorSelectChange}
                helperText="Please select your doctor"
              >
                {doctors.map((option) => (
                  <MenuItem key={option.value} value={option.value}>
                    {option.label}
                  </MenuItem>
                ))}
              </TextField>
            </div>
          </form>
        </>
    );
};

export default ReasonChoicePage;