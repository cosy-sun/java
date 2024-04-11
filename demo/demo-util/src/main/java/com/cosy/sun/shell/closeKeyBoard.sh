#!/bin/bash

id=`xinput | grep AT | awk '{print substr($7,4,2)}'`
echo $id
xinput set-prop ${id}  'Device Enabled' 0
