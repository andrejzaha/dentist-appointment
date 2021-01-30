import React, {
    useEffect,
    useState
} from "react";

import './reason-choice-page.scss';

import { Select } from 'antd';
import { DatePicker } from 'antd';

import { DownOutlined } from '@ant-design/icons';

const { Option } = Select;

function ReasonChoicePage() {

    const [
        reasonChoiceModel, setReasonChoiceModel
    ] = useState({});

    const [
      doctors, setDoctors
    ] = useState([]);

    const [
      doctorId, setDoctorId
    ] = useState('');

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

    const handleDoctorSelectChange = (selectedDoctorId) => {
      console.log('doctorId before=', doctorId);
      console.log('selected doctorId=', selectedDoctorId);
      setDoctorId(selectedDoctorId);
    };

    return (
        <>
          <Select
            defaultValue="Please select a doctor"
            className="doctor-select"
            onChange={handleDoctorSelectChange}
          >
            {
              doctors.map(option => (
                  <Option
                    key={option.value}
                    value={option.value}
                    onClick={handleDoctorSelectChange}
                  >
                    {option.label}
                  </Option>
                )
              )
            }
          </Select>
        </>
    );
};

export default ReasonChoicePage;