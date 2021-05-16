import React, {
    useEffect,
    useState
} from "react";

import './reason-choice-page.scss';

import { Select } from 'antd';
import { DatePicker } from 'antd';
import { Button } from 'antd';

import { DownOutlined } from '@ant-design/icons';

const { Option } = Select;

import {
  SELECTOR_TYPE_DOCTOR,
  SELECTOR_TYPE_REASON,
  SELECTOR_TYPE_PERIOD
} from './selector-helper.js';

function ReasonChoicePage() {

    const [
      doctorsForSelect, setDoctorsForSelect
    ] = useState([]);

    const [
      reasonsForSelect, setReasonsForSelect
    ] = useState([]);

    const [
      periodsForSelect, setPeriodsForSelect
    ] = useState([]);

    const [
      doctorId, setDoctorId
    ] = useState('');

    const [
      reasonId, setReasonId
    ] = useState('');

    const [
      periodId, setPeriodId
    ] = useState('');

    useEffect(() => {
        fetch('/backend/get-reason-choice-model')
            .then(response => response.json())
            .then(result => {
              setDoctorsForSelect(getItemForSelect(result.doctors, getDoctorForSelect));
              setReasonsForSelect(getItemForSelect(result.reasons, getReasonForSelect));
              setPeriodsForSelect(getItemForSelect(result.periodCodes, getPeriodForSelect));
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

    const getReasonForSelect = reasonFromModel => {
      return (
        {
          value: reasonFromModel?.id,
          label: reasonFromModel?.description + " (" + reasonFromModel.durationInMinutes + " minutes)"
        }
      );
    };

    const getPeriodForSelect = periodFromModel => {
      return (
        {
          value: periodFromModel?.label,
          label: periodFromModel?.label
        }
      );
    };

    const onSelectorChange = (selectorType, selectedValue) => {
      console.log('[getSelectorHandler] selectorType=', selectorType);
      console.log('[getSelectorHandler] selectedValue=', selectedValue);

      if (selectorType === SELECTOR_TYPE_DOCTOR) {
        setDoctorId(selectedValue);
      } else if (selectorType === SELECTOR_TYPE_REASON) {
        setReasonId(selectedValue);
      } else if (selectorType === SELECTOR_TYPE_PERIOD) {
        setPeriodId(selectedValue);
      }
    }

    const handleCheckAvailabilitiesClick = event => {
    console.log('[reason-choice-page] doctorId=' + doctorId);
    console.log('[reason-choice-page] reasonId=', reasonId);
    console.log('[reason-choice-page] periodId=', periodId);
      window.location.href = "/view";
    };

    return (
        <>
          <div className="select-container">
            <Select
              defaultValue="Please select a doctor"
              className="item-select"
              onChange={id => onSelectorChange(SELECTOR_TYPE_DOCTOR, id)}
            >
              {
                doctorsForSelect.map(d => (
                    <Option
                      key={d.value}
                      value={d.value}
                    >
                      {d.label}
                    </Option>
                  )
                )
              }
            </Select>
            <Select
              defaultValue="Please select a reason"
              className="item-select"
              onChange={id => onSelectorChange(SELECTOR_TYPE_REASON, id)}
            >
              {
                reasonsForSelect.map(r => (
                    <Option
                      key={r.value}
                      value={r.value}
                    >
                      {r.label}
                    </Option>
                  )
                )
              }
            </Select>
            <Select
              defaultValue="Please select a period"
              className="item-select"
              onChange={id => onSelectorChange(SELECTOR_TYPE_PERIOD, id)}
            >
              {
                periodsForSelect.map(p => (
                    <Option
                      key={p.value}
                      value={p.value}
                    >
                      {p.label}
                    </Option>
                  )
                )
              }
            </Select>
            <Button
              type="primary"
              onClick={handleCheckAvailabilitiesClick}
            >
              Check availabilities
            </Button>
          </div>
        </>
    );
};

export default ReasonChoicePage;
