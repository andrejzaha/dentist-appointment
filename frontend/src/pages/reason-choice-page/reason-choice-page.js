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
      doctorsForSelect, setDoctorsForSelect
    ] = useState([]);

    const [
      reasonsForSelect, setReasonsForSelect
    ] = useState([]);

    const [
      doctorId, setDoctorId
    ] = useState('');

    const [
      reasonId, setReasonId
    ] = useState('');

    useEffect(() => {
        fetch('/backend/get-reason-choice-model')
            .then(response => response.json())
            .then(result => {
              setReasonChoiceModel(result);
              setDoctorsForSelect(getItemForSelect(result.doctors, getDoctorForSelect));
              setReasonsForSelect(getItemForSelect(result.reasons, getReasonForSelect));
            });
    }, []);

    const getItemForSelect = (itemsFromBackend, mappingFunction) => {
      return itemsFromBackend
        ? itemsFromBackend.map(mappingFunction)
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

    const getReasonForSelect = reasonFromModel => {
      return (
        {
          value: reasonFromModel?.id,
          label: reasonFromModel?.description + " (" + reasonFromModel.durationInMinutes + " minutes)"
        }
      );
    };

    const handleReasonSelectChange = (selectedReasonId) => {
      console.log('reasonId before=', reasonId);
      console.log('selected reasonId=', selectedReasonId);

      setReasonId(selectedReasonId);
    };

    return (
        <>
          <Select
            defaultValue="Please select a doctor"
            className="doctor-select"
            onChange={handleDoctorSelectChange}
          >
            {
              doctorsForSelect.map(d => (
                  <Option
                    key={d.value}
                    value={d.value}
                    onClick={handleDoctorSelectChange}
                  >
                    {d.label}
                  </Option>
                )
              )
            }
          </Select>
          <Select
            defaultValue="Please select a reason"
            className="reason-select"
            onChange={handleReasonSelectChange}
          >
            {
              reasonsForSelect.map(r => (
                  <Option
                    key={r.value}
                    value={r.value}
                    onClick={handleReasonSelectChange}
                  >
                    {r.label}
                  </Option>
                )
              )
            }
          </Select>
        </>
    );
};

export default ReasonChoicePage;
